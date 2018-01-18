package org.hn.util;

public class PageBean {
	private int pageSize=5;
	private int currentPage=1;
	private int totalCount;
	private int totalPageCount;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPageCount = this.totalCount % this.pageSize == 0 ? 
				this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	
	
	
}	
