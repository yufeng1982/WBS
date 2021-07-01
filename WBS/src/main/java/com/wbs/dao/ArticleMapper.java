package com.wbs.dao;

import com.wbs.dto.ArticleDto;
import com.wbs.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author YF
 * @since 2021-06-29
 */
public interface ArticleMapper extends BaseMapper<Article> {

	public IPage<Map<String, Object>> selectByPage(Page<?> page, ArticleDto dto);
}
