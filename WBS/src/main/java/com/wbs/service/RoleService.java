package com.wbs.service;

import com.wbs.entity.Role;
import com.wbs.dao.RoleMapper;
import  com.wbs.dto.RoleDto;

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
 * 角色表  服务实现类
 * </p>
 *
 * @author YF
 * @since 2021-07-01
 */
@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> {
	
	@Autowired private RoleMapper roleMapper;
	
	@Transactional(readOnly = true)
	public IPage<Map<String, Object>> selectList(RoleDto dto) {
		Page<Map<String, Object>> page = new Page<Map<String,Object>>(dto.getPageNo(), dto.getPageSize());
		return roleMapper.selectByPage(page, dto);
	}
	
	@Transactional
	public Role saveOrUpdate(RoleDto dto) {
		Role entity = null;
		if (StringUtils.isBlank(dto.getId())) {
			entity = new Role();
		} else {
			entity = getById(dto.getId());
		}
		BeanUtils.copyProperties(dto, entity, "id");
		saveOrUpdate(entity);
		return entity;
	}
	
	@Transactional
	public boolean delete(RoleDto dto) {
		return removeById(dto.getId());
	}
}
