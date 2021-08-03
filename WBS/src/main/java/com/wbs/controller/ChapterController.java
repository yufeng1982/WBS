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
import com.wbs.dto.ChapterDto;
import com.wbs.entity.Chapter;
import com.wbs.service.ChapterService;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YF
 * @since 2021-06-29
 */
@RestController
@RequestMapping("/api/chapter")
public class ChapterController extends BaseController {
	@Autowired private ChapterService chapterService;
	
	@GetMapping("/list")
	public Response<Map<String, Object>> list(ChapterDto dto) {
		Response<Map<String, Object>> res = new Response<Map<String,Object>>();
		res.setResult(getResult(chapterService.selectList(dto)));
		return res;
	}
	
	@PostMapping("/save")
	public Response<Chapter> save(@RequestBody ChapterDto dto) {
		Response<Chapter> res = new Response<Chapter>();
		res.setResult(chapterService.saveOrUpdate(dto));
		return res;
	}
	
	@PutMapping("/update")
	public Response<Chapter> update(@RequestBody ChapterDto dto) {
		Response<Chapter> res = new Response<Chapter>();
		res.setResult(chapterService.saveOrUpdate(dto));
		return res;
	}
	
	@DeleteMapping("/delete")
	public Response<Boolean> delete(@RequestBody ChapterDto dto) {
		Response<Boolean> res = new Response<Boolean>();
		res.setResult(chapterService.delete(dto));
		return res;
	}
}

