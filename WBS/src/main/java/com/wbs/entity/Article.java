package com.wbs.entity;

import com.wbs.base.BaseEntity;
import com.wbs.enums.Category;
import com.wbs.enums.Status;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
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
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private Category category;

    /**
     * 状态
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private Status status;


}
