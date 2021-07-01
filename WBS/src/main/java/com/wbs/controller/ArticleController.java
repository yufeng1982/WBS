package com.wbs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.wbs.base.BaseController;

import com.wbs.base.Response;
import com.wbs.dto.ArticleDto;
import com.wbs.entity.Article;
import com.wbs.service.ArticleService;


/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author YF
 * @since 2021-06-29
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {
	@Autowired private ArticleService articleService;
	
	@GetMapping("/list")
	public Response<Map<String, Object>> list(ArticleDto dto) {
		Response<Map<String, Object>> res = new Response<Map<String,Object>>();
		res.setResult(getResult(articleService.selectList(dto)));
		return res;
	}
	
	@PostMapping("/save")
	public Response<Article> save(@RequestBody ArticleDto dto) {
		Response<Article> res = new Response<Article>();
		res.setResult(articleService.saveOrUpdate(dto));
		return res;
	}
	
	@PutMapping("/update")
	public Response<Article> update(@RequestBody ArticleDto dto) {
		Response<Article> res = new Response<Article>();
		res.setResult(articleService.saveOrUpdate(dto));
		return res;
	}
	
	@DeleteMapping("/delete")
	public Response<Boolean> delete(@RequestBody ArticleDto dto) {
		Response<Boolean> res = new Response<Boolean>();
		res.setResult(articleService.delete(dto));
		return res;
	}
}

