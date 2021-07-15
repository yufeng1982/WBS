package com.wbs.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wbs.base.BaseEntity;
import com.wbs.handler.JsonTypeHandler;

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
@TableName(value="user",schema="public", autoResultMap = true)
public class User extends BaseEntity {

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
     * 电子邮件
     */
    private String email;

    /**
     * 角色列表
     */
    @TableField(typeHandler = JsonTypeHandler.class)
    private Object roles;

 
}
