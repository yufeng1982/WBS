package com.wbs.dao;

import com.wbs.dto.UserDto;
import com.wbs.entity.User;
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
public interface UserMapper extends BaseMapper<User> {

	public IPage<Map<String, Object>> selectByPage(Page<?> page, UserDto dto);
	public User getByUsername(String username);
}
