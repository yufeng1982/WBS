package com.wbs.dao;

import com.wbs.dto.MenuInfoDto;
import com.wbs.entity.MenuInfo;
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
 * @since 2021-07-15
 */
public interface MenuInfoMapper extends BaseMapper<MenuInfo> {

	public IPage<Map<String, Object>> selectByPage(Page<?> page, MenuInfoDto dto);
}
