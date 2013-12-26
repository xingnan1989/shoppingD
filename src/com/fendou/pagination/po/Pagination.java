package com.fendou.pagination.po;

public class Pagination {
	private int totalPage;//一共多少页
	private int totalRecord;//一共几条记录
	private int currentPage;//当前在那页
	private int currentPageRecord = 10;//每页多少条记录
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int currentPageRecord) {
		if(totalRecord%currentPageRecord == 0) {
			this.totalPage = totalRecord/currentPageRecord;
		} else {
			this.totalPage = totalRecord/currentPageRecord + 1;
		}
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentPageRecord() {
		return currentPageRecord;
	}
	public void setCurrentPageRecord(int currentPageRecord) {
		this.currentPageRecord = currentPageRecord;
	}
}
