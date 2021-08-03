package com.wbs.service;

import com.wbs.entity.MenuInfo;
import com.wbs.dao.MenuInfoMapper;
import  com.wbs.dto.MenuInfoDto;

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
 *   服务实现类
 * </p>
 *
 * @author YF
 * @since 2021-07-15
 */
@Service
public class MenuInfoService extends ServiceImpl<MenuInfoMapper, MenuInfo> {
	
	@Autowired private MenuInfoMapper menuInfoMapper;
	
	@Transactional(readOnly = true)
	public IPage<Map<String, Object>> selectList(MenuInfoDto dto) {
		Page<Map<String, Object>> page = new Page<Map<String,Object>>(dto.getPageNo(), dto.getPageSize());
		return menuInfoMapper.selectByPage(page, dto);
	}
	
	@Transactional
	public MenuInfo saveOrUpdate(MenuInfoDto dto) {
		MenuInfo entity = null;
		if (StringUtils.isBlank(dto.getId())) {
			entity = new MenuInfo();
		} else {
			entity = getById(dto.getId());
		}
		BeanUtils.copyProperties(dto, entity, "id");
		saveOrUpdate(entity);
		return entity;
	}
	
	@Transactional
	public boolean delete(MenuInfoDto dto) {
		return removeById(dto.getId());
	}
}
