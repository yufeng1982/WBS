package com.wbs.dto;

import com.wbs.entity.Role;
import java.io.Serializable;
import com.wbs.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author YF
 * @since 2021-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleDto extends BaseDto<Role> implements Serializable {


	private static final long serialVersionUID = 1L;

	/**
     * 角色编号
     */
	private String code;

	/**
     * 角色名称
     */
	private String name;

	/**
     * 角色描述
     */
	private String description;



}
