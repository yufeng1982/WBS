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
import com.wbs.dto.MenuInfoDto;
import com.wbs.entity.MenuInfo;
import com.wbs.service.MenuInfoService;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YF
 * @since 2021-07-15
 */
@RestController
@RequestMapping("/api/menuinfo")
public class MenuInfoController extends BaseController {
	@Autowired private MenuInfoService menuInfoService;
	
	@GetMapping("/list")
	public Response<Map<String, Object>> list(MenuInfoDto dto) {
		Response<Map<String, Object>> res = new Response<Map<String,Object>>();
		res.setResult(getResult(menuInfoService.selectList(dto)));
		return res;
	}
	
	@PostMapping("/save")
	public Response<MenuInfo> save(@RequestBody MenuInfoDto dto) {
		Response<MenuInfo> res = new Response<MenuInfo>();
		res.setResult(menuInfoService.saveOrUpdate(dto));
		return res;
	}
	
	@PutMapping("/update")
	public Response<MenuInfo> update(@RequestBody MenuInfoDto dto) {
		Response<MenuInfo> res = new Response<MenuInfo>();
		res.setResult(menuInfoService.saveOrUpdate(dto));
		return res;
	}
	
	@DeleteMapping("/delete")
	public Response<Boolean> delete(@RequestBody MenuInfoDto dto) {
		Response<Boolean> res = new Response<Boolean>();
		res.setResult(menuInfoService.delete(dto));
		return res;
	}
}

