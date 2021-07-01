package com.wbs.base;

import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author Administrator
 *
 */
public class BaseController {
	
//	@Autowired
//	private SysUserService sysUserService;
	
	/**
	 * 获取登录人信息
	 * @return
	 */
//	protected SysUser getCurrentUser() {
//		Subject subject = SecurityUtils.getSubject();
//		if(subject.isAuthenticated()) {
//			String token = (String) subject.getPrincipal();
//	        String username = JWTUtil.getUsername(token);
//	        SysUser sysUser = sysUserService.getUserByLoginName(username);
//	        return sysUser;
//		}
//		return null;
//		
//	}
	
	protected <T> Map<String, Object> getResult(IPage<T> pages) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", pages.getRecords());
		map.put("pageNo", pages.getCurrent());
		map.put("pageSize", pages.getSize());
		map.put("totalCount", pages.getTotal());
		map.put("totalPage", pages.getPages());
		return map;
	}
}
