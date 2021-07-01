package com.wbs.service;

import com.wbs.entity.Customer;
import com.wbs.dao.CustomerMapper;
import  com.wbs.dto.CustomerDto;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 客户关系  服务实现类
 * </p>
 *
 * @author YF
 * @since 2021-06-29
 */
@Service
public class CustomerService extends ServiceImpl<CustomerMapper, Customer> {
	
	@Autowired private CustomerMapper customerMapper;
	
	@Transactional(readOnly = true)
	public IPage<Map<String, Object>> selectList(CustomerDto dto) {
		Page<Map<String, Object>> page = new Page<Map<String,Object>>(dto.getPageNo(), dto.getPageSize());
		return customerMapper.selectByPage(page, dto);
	}
	
	@Transactional
	public Customer saveOrUpdate(CustomerDto dto) {
		Customer entity = null;
		if (StringUtils.isBlank(dto.getId())) {
			entity = new Customer();
		} else {
			entity = getById(dto.getId());
		}
		BeanUtils.copyProperties(dto, entity, "id");
		saveOrUpdate(entity);
		return entity;
	}
	
	@Transactional
	public boolean delete(CustomerDto dto) {
		return removeById(dto.getId());
	}
}
