package com.wbs.dto;

import com.wbs.entity.Chapter;
import java.io.Serializable;
import com.wbs.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author YF
 * @since 2021-06-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChapterDto extends BaseDto<Chapter> implements Serializable {


	private static final long serialVersionUID = 1L;

	/**
     * 章节号
     */
	private String code;

	/**
     * 内容
     */
	private String contents;

	/**
     * 章节标题
     */
	private String title;

	/**
     * 关联文章ID
     */
	private String artilceId;



}
