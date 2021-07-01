package com.wbs.dto;

import com.wbs.entity.Article;
import java.io.Serializable;
import com.wbs.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author YF
 * @since 2021-06-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ArticleDto extends BaseDto<Article> implements Serializable {


	private static final long serialVersionUID = 1L;

	/**
     * 标题
     */
	private String title;

	/**
     * 编号
     */
	private String code;

	/**
     * 作者
     */
	private String author;

	/**
     * 类别
     */
	private Integer category;

	/**
     * 状态
     */
	private String status;



}
