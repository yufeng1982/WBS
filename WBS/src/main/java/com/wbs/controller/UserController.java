package com.wbs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wbs.base.BaseController;
import com.wbs.base.Response;
import com.wbs.dto.UserDto;
import com.wbs.entity.User;
import com.wbs.service.UserService;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YF
 * @since 2021-06-30
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired private UserService usersService;
	
	@GetMapping("/list")
	public Response<Map<String, Object>> list(UserDto dto) {
		Response<Map<String, Object>> res = new Response<Map<String,Object>>();
		res.setResult(getResult(usersService.selectList(dto)));
		return res;
	}
	
	@PostMapping("/save")
	public Response<User> save(@RequestBody UserDto dto) {
		Response<User> res = new Response<User>();
		res.setResult(usersService.saveOrUpdate(dto));
		return res;
	}
	
	@PutMapping("/update")
	public Response<User> update(@RequestBody UserDto dto) {
		Response<User> res = new Response<User>();
		res.setResult(usersService.saveOrUpdate(dto));
		return res;
	}
	
	@DeleteMapping("/delete")
	public Response<Boolean> delete(@RequestBody UserDto dto) {
		Response<Boolean> res = new Response<Boolean>();
		res.setResult(usersService.delete(dto));
		return res;
	}
	
	@PostMapping(value = "/login")
    public Response<Map<String, Object>> login(@RequestBody UserDto dto) {
    	
		Response<Map<String, Object>> response = new Response<Map<String, Object>>();
		String token = usersService.login(dto);
		
		if(!StringUtils.isBlank(token)) {
			 Map<String, Object> map = new HashMap<String, Object>();
		        map.put("AuthToken", token);
		        response.setResult(map);
				response.setSuccess(true);
			 	return response;
		}
		
		response.setSuccess(false);

	 	return response;
    }
	
	@PostMapping(value = "/logout")
    public Response<Map<String, Object>> logout(Model m, HttpServletRequest request) {
		Response<Map<String, Object>> response = new Response<Map<String, Object>>();
    	
		Subject subject = SecurityUtils.getSubject();
    	subject.logout();
    	
    	Map<String, Object> map = new HashMap<String, Object>();
        map.put("AuthToken", "logout");
		response.setSuccess(true);
		
	 	return response;
    }
}

