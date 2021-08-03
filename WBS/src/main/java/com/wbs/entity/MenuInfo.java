package com.wbs.entity;

import com.wbs.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value="menu_info",schema="public")
public class MenuInfo extends BaseEntity {

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
