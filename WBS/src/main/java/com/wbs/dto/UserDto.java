package com.wbs.dto;

import com.wbs.entity.User;
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
 * @since 2021-06-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends BaseDto<User> implements Serializable {


	private static final long serialVersionUID = 1L;

	/**
     * 用户名
     */
	private String username;

	/**
     * 密码
     */
	private String password;

	/**
     * 盐值
     */
	private String salt;

	/**
     * 手机号码
     */
	private String mobile;

	/**
     * 点子邮件
     */
	private String email;

	/**
     * 角色列表
     */
	private String roles;



}
