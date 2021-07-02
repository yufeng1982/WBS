package com.wbs.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wbs.entity.Users;
import com.wbs.service.UsersService;

/**
 * <p>
 * 	ShiroRealm 自定义realm
 * </p>
 *
 * @author YF
 * @since 2021-06-29
 */
public class ShiroRealm extends AuthorizingRealm {

	@Autowired private UsersService userService;
	

	//授权
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String username = (String) principalCollection.fromRealm(getName()).iterator().next();
		Users user = userService.getOne(new QueryWrapper<Users>().eq("username", username));
	    if (null == user) {
	         return null;
	    } else {
	 		 SimpleAuthorizationInfo result = new SimpleAuthorizationInfo();
	         return result;
	    }
	}
	
	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof JWTToken;
	}
	//认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		String token = (String) authcToken.getPrincipal();
		
		if(!StringUtils.isBlank(token) && token.equals("logout")) {
			return null;
		}
	    String username = JWTUtil.getUsername(token);
	
	    Users user = userService.getOne(new QueryWrapper<Users>().eq("username", username));
	
	
	    // 用户不会空
	    if (user != null) {
	
	        // 密码验证
	        if (!JWTUtil.verify(token, username, user.getPassword())) {
	            	return null;
	        }
	        
	        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(token, token, this.getClass().getSimpleName());
	
	        return authcInfo;
	    } else {
	    	return null;
	    }
	}
	
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}
}
