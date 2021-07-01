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
 * @since 2021-06-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value="chapter",schema="article")
public class Chapter extends BaseEntity {

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
