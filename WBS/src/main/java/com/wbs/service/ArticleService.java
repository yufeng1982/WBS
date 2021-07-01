package com.wbs.service;

import com.wbs.entity.Article;
import com.wbs.dao.ArticleMapper;
import  com.wbs.dto.ArticleDto;

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
 * 文章表  服务实现类
 * </p>
 *
 * @author YF
 * @since 2021-06-29
 */
@Service
public class ArticleService extends ServiceImpl<ArticleMapper, Article> {
	
	@Autowired private ArticleMapper articleMapper;
	
	@Transactional(readOnly = true)
	public IPage<Map<String, Object>> selectList(ArticleDto dto) {
		Page<Map<String, Object>> page = new Page<Map<String,Object>>(dto.getPageNo(), dto.getPageSize());
		return articleMapper.selectByPage(page, dto);
	}
	
	@Transactional
	public Article saveOrUpdate(ArticleDto dto) {
		Article entity = null;
		if (StringUtils.isBlank(dto.getId())) {
			entity = new Article();
		} else {
			entity = getById(dto.getId());
		}
		BeanUtils.copyProperties(dto, entity, "id");
		saveOrUpdate(entity);
		return entity;
	}
	
	@Transactional
	public boolean delete(ArticleDto dto) {
		return removeById(dto.getId());
	}
}
