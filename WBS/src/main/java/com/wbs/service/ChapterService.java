package com.wbs.service;

import com.wbs.entity.Chapter;
import com.wbs.dao.ChapterMapper;
import  com.wbs.dto.ChapterDto;

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
 * @since 2021-06-29
 */
@Service
public class ChapterService extends ServiceImpl<ChapterMapper, Chapter> {
	
	@Autowired private ChapterMapper chapterMapper;
	
	@Transactional(readOnly = true)
	public IPage<Map<String, Object>> selectList(ChapterDto dto) {
		Page<Map<String, Object>> page = new Page<Map<String,Object>>(dto.getPageNo(), dto.getPageSize());
		return chapterMapper.selectByPage(page, dto);
	}
	
	@Transactional
	public Chapter saveOrUpdate(ChapterDto dto) {
		Chapter entity = null;
		if (StringUtils.isBlank(dto.getId())) {
			entity = new Chapter();
		} else {
			entity = getById(dto.getId());
		}
		BeanUtils.copyProperties(dto, entity, "id");
		saveOrUpdate(entity);
		return entity;
	}
	
	@Transactional
	public boolean delete(ChapterDto dto) {
		return removeById(dto.getId());
	}
}
