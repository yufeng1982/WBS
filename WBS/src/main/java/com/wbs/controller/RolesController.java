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
import com.wbs.dto.RolesDto;
import com.wbs.entity.Roles;
import com.wbs.service.RolesService;


/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author YF
 * @since 2021-07-01
 */
@RestController
@RequestMapping("/roles")
public class RolesController extends BaseController {
	@Autowired private RolesService rolesService;
	
	@GetMapping("/list")
	public Response<Map<String, Object>> list(RolesDto dto) {
		Response<Map<String, Object>> res = new Response<Map<String,Object>>();
		res.setResult(getResult(rolesService.selectList(dto)));
		return res;
	}
	
	@PostMapping("/save")
	public Response<Roles> save(@RequestBody RolesDto dto) {
		Response<Roles> res = new Response<Roles>();
		res.setResult(rolesService.saveOrUpdate(dto));
		return res;
	}
	
	@PutMapping("/update")
	public Response<Roles> update(@RequestBody RolesDto dto) {
		Response<Roles> res = new Response<Roles>();
		res.setResult(rolesService.saveOrUpdate(dto));
		return res;
	}
	
	@DeleteMapping("/delete")
	public Response<Boolean> delete(@RequestBody RolesDto dto) {
		Response<Boolean> res = new Response<Boolean>();
		res.setResult(rolesService.delete(dto));
		return res;
	}
}

