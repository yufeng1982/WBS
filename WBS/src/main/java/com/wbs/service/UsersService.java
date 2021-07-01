package com.wbs.service;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wbs.dao.UsersMapper;
import  com.wbs.dto.UsersDto;
import com.wbs.entity.Users;
import com.wbs.shiro.JWTToken;
import com.wbs.shiro.JWTUtil;
import com.wbs.utils.Digests;
import com.wbs.utils.EncodeUtils;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author YF
 * @since 2021-06-30
 */
@Service
public class UsersService extends ServiceImpl<UsersMapper, Users> {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
	@Autowired private UsersMapper usersMapper;
	
	public String login(UsersDto usersDto) {
		Users users = this.getOne(new QueryWrapper<Users>().eq("username", usersDto.getUsername()));
        String token = "";
        if(users != null) {
        	if(this.validatePassword(usersDto.getPassword(), users)) {
            	token = JWTUtil.sign(usersDto.getUsername(),  users.getPassword());
            	Subject subject = SecurityUtils.getSubject();
    			JWTToken jwtToken =new JWTToken(token);
//    			SysToken sysToken = new SysToken();
//		        sysToken.setId(token);
//		        sysToken.setLoginDate(new Date());
//		        sysTokenService.saveOrUpdate(sysToken);
    	        subject.login(jwtToken);
    	        if(subject.isAuthenticated()) {
    	    		return token;
    	        }
        	}
        }
		return token;
	}
	
	@Transactional(readOnly = true)
	public IPage<Map<String, Object>> selectList(UsersDto dto) {
		Page<Map<String, Object>> page = new Page<Map<String,Object>>(dto.getPageNo(), dto.getPageSize());
		return usersMapper.selectByPage(page, dto);
	}
	
	@Transactional
	public Users saveOrUpdate(UsersDto dto) {
		Users entity = null;
		if (StringUtils.isBlank(dto.getId())) {
			entity = new Users();
		} else {
			entity = getById(dto.getId());
		}
		BeanUtils.copyProperties(dto, entity, "id");
		encryptPassword(entity);
		saveOrUpdate(entity);
		return entity;
	}
	
	@Transactional
	public boolean delete(UsersDto dto) {
		return removeById(dto.getId());
	}
	
	private void encryptPassword(Users user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(EncodeUtils.encodeHex(salt));
		byte[] hashPassword = Digests.sha1(user.getPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(EncodeUtils.encodeHex(hashPassword));
		
	}
	
	public boolean validatePassword(String plainPassword, Users user) {
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), EncodeUtils.decodeHex(user.getSalt()), HASH_INTERATIONS);
		return user.getPassword().equals(EncodeUtils.encodeHex(hashPassword));
	}
	
}
