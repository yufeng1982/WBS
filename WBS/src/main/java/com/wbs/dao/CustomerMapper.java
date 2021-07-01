package com.wbs.dao;

import com.wbs.dto.CustomerDto;
import com.wbs.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 客户关系 Mapper 接口
 * </p>
 *
 * @author YF
 * @since 2021-06-29
 */
public interface CustomerMapper extends BaseMapper<Customer> {

	public IPage<Map<String, Object>> selectByPage(Page<?> page, CustomerDto dto);
}
