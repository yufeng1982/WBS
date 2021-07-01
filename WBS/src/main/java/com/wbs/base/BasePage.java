package com.wbs.base;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * 分页工具类
 * 
 * @author Administrator
 * @2016年5月4日@下午1:25:24
 */
public class BasePage <T> extends Page<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int pageNo; // 当前页

	private int page; // 当前页

	private int pageSize = 10; // 每页显示多少条

	private int total;// 总条数

	private int pageTotal;// 总页数
	
	private long startNum; // 从哪开始查询
	
	private String sortField;//排序字段
	
	private String sortOrder;//排序方式（ascend，descend）

	 public BasePage() {
	        
	 }
	 
	 public BasePage(int current, int size) {
	        super(current, size);
	    }
	
	// 错误区域
	private String errorArea;
	// 错误内容
	private String errorCon;

	private List<T> rows;
	
	public int getPageNo() {
		if(this.page >0) {
			return page;
		}

		return pageNo;
	}

	public void setPageNo(int pageNo) {
		if (pageNo == 0) {
			pageNo = 1;
		}
		this.pageNo = pageNo;
	}

	public int getPageSize() {

		return pageSize;
	}

	public void setPageSize(int pageSize) {

		this.pageSize = pageSize;
	}


	public void setTotal(int total) {

		this.total = total;
	}

	public long getBegin() {
		if (this.getPageNo() == 0) {
			this.setPageNo(1);
		}
		return ((this.getPageNo() - 1) * this.pageSize);
	}


	public long getEnd() {
		if (this.getPageNo() == 0) {
			this.setPageNo(1);
		}
		return pageNo * pageSize;
	}


	public int getPageTotal() {
		pageTotal = (total + pageSize - 1) / pageSize;
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public String getErrorArea() {
		return errorArea;
	}

	public void setErrorArea(String errorArea) {
		this.errorArea = errorArea;
	}

	public String getErrorCon() {
		return errorCon;
	}

	public void setErrorCon(String errorCon) {
		this.errorCon = errorCon;
	}

	public long getStartNum() {
		return startNum;
	}

	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	
}
