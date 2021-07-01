package com.wbs.entity;

import com.wbs.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value="article",schema="article")
public class Article extends BaseEntity {

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
