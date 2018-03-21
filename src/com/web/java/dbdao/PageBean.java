package com.web.java.dbdao;

public class PageBean {

	private static final int size = 5;
	private int count;// ���ݵ�������
	private int currPage; // ��ǰҳ��
	private int pageSize; // ÿҳ����
	private int pageCount; // һ���ж���ҳ

	public PageBean() {
		// TODO �Զ����ɵĹ��캯�����
		this.pageSize = size;
		this.currPage = 1;
	}

	public PageBean(int pageSize) {
		// TODO �Զ����ɵĹ��캯�����
		this.pageSize = pageSize;
		this.currPage = 1;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		//������ҳ��
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
