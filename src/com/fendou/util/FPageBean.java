package com.fendou.util;

/**
 * 分页功能
 * @author fendou
 *
 */
public class FPageBean {
	
	// 总的页面数
	private int pageTotal;
	
	// 页面记录数
	private int pageSize;
	
	// 记录数
	private int reportTotal;
	
	// 页码
	private int pageNumber;
	
	// 下一页
	private boolean next;
	
	// 上一页
	private boolean up;

	public int getPageTotal() {
		return pageTotal;
	}

	// 设置总的页面数
	public void setPageTotal() {
		if (reportTotal > 0) {
			this.pageTotal = reportTotal % pageNumber == 0 ? reportTotal
					/ pageNumber : reportTotal / pageNumber + 1;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getReportTotal() {
		return reportTotal;
	}

	public void setReportTotal(int reportTotal) {
		this.reportTotal = reportTotal;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	// 判断是有拥有下一页，如果没有则没由链接
	public boolean isNext() {
		return next;
	}

	public void setNext() {
		if (pageSize < pageTotal)
			next = true;
	}

	// 判断是否有上一页，如果没有则没有链接
	public boolean isUp() {
		return up;
	}

	public void setUp() {
		if (pageSize > 1)
			up = true;
	}

}
