package com.wbs.dto;

import com.wbs.entity.Customer;
import java.io.Serializable;
import com.wbs.base.BaseDto;
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
public class CustomerDto extends BaseDto<Customer> implements Serializable {


	private static final long serialVersionUID = 1L;

	/**
     * 名称
     */
	private String code;

	/**
     * 
     */
	private String name;



}
