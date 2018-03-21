package com.web.java.dbdao;

public class PageBean {

	private static final int size = 5;
	private int count;// 数据的总条数
	private int currPage; // 当前页数
	private int pageSize; // 每页条数
	private int pageCount; // 一个有多少页

	public PageBean() {
		// TODO 自动生成的构造函数存根
		this.pageSize = size;
		this.currPage = 1;
	}

	public PageBean(int pageSize) {
		// TODO 自动生成的构造函数存根
		this.pageSize = pageSize;
		this.currPage = 1;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		//计算总页数
		this.pageCount = count % this.pageSize == 0 ? count / this.pageSize : count / this.pageSize + 1;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int prePage() {
		if (this.currPage == 1) {
			return 1;
		}
		return this.currPage - 1;
	}

	public int nextPage() {
		if (this.currPage == this.getPageCount()) {
			return this.getPageCount();
		} else {
			return this.currPage + 1;
		}
	}

	public int getStart() {
		return this.pageSize * (this.getCurrPage() - 1);
	}

}
