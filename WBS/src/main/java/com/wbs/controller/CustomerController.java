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
import com.wbs.dto.CustomerDto;
import com.wbs.entity.Customer;
import com.wbs.service.CustomerService;


/**
 * <p>
 * 客户关系 前端控制器
 * </p>
 *
 * @author YF
 * @since 2021-06-29
 */
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController {
	@Autowired private CustomerService customerService;
	
	@GetMapping("/list")
	public Response<Map<String, Object>> list(CustomerDto dto) {
		Response<Map<String, Object>> res = new Response<Map<String,Object>>();
		res.setResult(getResult(customerService.selectList(dto)));
		return res;
	}
	
	@PostMapping("/save")
	public Response<Customer> save(@RequestBody CustomerDto dto) {
		Response<Customer> res = new Response<Customer>();
		res.setResult(customerService.saveOrUpdate(dto));
		return res;
	}
	
	@PutMapping("/update")
	public Response<Customer> update(@RequestBody CustomerDto dto) {
		Response<Customer> res = new Response<Customer>();
		res.setResult(customerService.saveOrUpdate(dto));
		return res;
	}
	
	@DeleteMapping("/delete")
	public Response<Boolean> delete(@RequestBody CustomerDto dto) {
		Response<Boolean> res = new Response<Boolean>();
		res.setResult(customerService.delete(dto));
		return res;
	}
}

