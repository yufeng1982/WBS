package com.wbs.entity;

import com.wbs.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 客户关系
 * </p>
 *
 * @author YF
 * @since 2021-06-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value="customer",schema="crm")
public class Customer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String code;

    private String name;


}
