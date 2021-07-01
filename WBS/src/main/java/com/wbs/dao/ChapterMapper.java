package com.wbs.dao;

import com.wbs.dto.ChapterDto;
import com.wbs.entity.Chapter;
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
 * @since 2021-06-29
 */
public interface ChapterMapper extends BaseMapper<Chapter> {

	public IPage<Map<String, Object>> selectByPage(Page<?> page, ChapterDto dto);
}
