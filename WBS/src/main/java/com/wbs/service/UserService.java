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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wbs.dao.UserMapper;
import  com.wbs.dto.UserDto;
import com.wbs.entity.User;
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
public class UserService extends ServiceImpl<UserMapper, User> {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
	@Autowired private UserMapper userMapper;
	@Autowired private RoleService roleService;
	
	public String login(UserDto usersDto) {
		User users = this.getOne(new QueryWrapper<User>().eq("username", usersDto.getUsername()));
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
	public IPage<Map<String, Object>> selectList(UserDto dto) {
		Page<Map<String, Object>> page = new Page<Map<String,Object>>(dto.getPageNo(), dto.getPageSize());
		return userMapper.selectByPage(page, dto);
	}
	
	@Transactional(readOnly = true)
	public User getByUsername(String username) {
		return userMapper.getByUsername(username);
	}
	
	@Transactional
	public User saveOrUpdate(UserDto dto) {
		User entity = null;
		if (StringUtils.isBlank(dto.getId())) {
			entity = new User();
		} else {
			entity = getById(dto.getId());
		}
		BeanUtils.copyProperties(dto, entity, "id");
		if(StringUtils.isBlank(dto.getId())) encryptPassword(entity);
		try {
			entity.setRoles(new ObjectMapper().writeValueAsString(roleService.list()));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		saveOrUpdate(entity);
		return entity;
	}
	
	@Transactional
	public boolean delete(UserDto dto) {
		return removeById(dto.getId());
	}
	
	private void encryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(EncodeUtils.encodeHex(salt));
		byte[] hashPassword = Digests.sha1(user.getPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(EncodeUtils.encodeHex(hashPassword));
		
	}
	
	public boolean validatePassword(String plainPassword, User user) {
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), EncodeUtils.decodeHex(user.getSalt()), HASH_INTERATIONS);
		return user.getPassword().equals(EncodeUtils.encodeHex(hashPassword));
	}
	
}
