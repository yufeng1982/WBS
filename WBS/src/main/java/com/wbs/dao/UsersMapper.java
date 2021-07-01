package com.wbs.dao;

import com.wbs.dto.UsersDto;
import com.wbs.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author YF
 * @since 2021-06-30
 */
public interface UsersMapper extends BaseMapper<Users> {

	public IPage<Map<String, Object>> selectByPage(Page<?> page, UsersDto dto);
}
