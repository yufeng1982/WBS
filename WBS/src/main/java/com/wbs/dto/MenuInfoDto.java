package com.wbs.dto;

import com.wbs.entity.MenuInfo;
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
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuInfoDto extends BaseDto<MenuInfo> implements Serializable {


	private static final long serialVersionUID = 1L;

	/**
     * 名称
     */
	private String name;

	/**
     * 标题
     */
	private String title;

	/**
     * 图标
     */
	private String icon;

	/**
     * 路径地址
     */
	private String path;

	/**
     * 组件
     */
	private String component;

	/**
     * 重定向
     */
	private String redirect;

	/**
     * 父节点
     */
	private String parentId;

	/**
     * 是否叶子节点
     */
	private Boolean leaf;



}
