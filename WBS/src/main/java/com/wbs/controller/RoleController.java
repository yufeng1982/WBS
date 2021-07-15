package com.wbs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.wbs.base.BaseController;

import com.wbs.base.Response;
import com.wbs.dto.RoleDto;
import com.wbs.entity.Role;
import com.wbs.service.RoleService;


/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author YF
 * @since 2021-07-01
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {
	@Autowired private RoleService roleService;
	
	@GetMapping("/list")
	public Response<Map<String, Object>> list(RoleDto dto) {
		Response<Map<String, Object>> res = new Response<Map<String,Object>>();
		res.setResult(getResult(roleService.selectList(dto)));
		return res;
	}
	
	@PostMapping("/save")
	public Response<Role> save(@RequestBody RoleDto dto) {
		Response<Role> res = new Response<Role>();
		res.setResult(roleService.saveOrUpdate(dto));
		return res;
	}
	
	@PutMapping("/update")
	public Response<Role> update(@RequestBody RoleDto dto) {
		Response<Role> res = new Response<Role>();
		res.setResult(roleService.saveOrUpdate(dto));
		return res;
	}
	
	@DeleteMapping("/delete")
	public Response<Boolean> delete(@RequestBody RoleDto dto) {
		Response<Boolean> res = new Response<Boolean>();
		res.setResult(roleService.delete(dto));
		return res;
	}
}

