package com.wbs.dao;

import com.wbs.dto.RoleDto;
import com.wbs.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author YF
 * @since 2021-07-01
 */
public interface RoleMapper extends BaseMapper<Role> {

	public IPage<Map<String, Object>> selectByPage(Page<?> page, RoleDto dto);
}
