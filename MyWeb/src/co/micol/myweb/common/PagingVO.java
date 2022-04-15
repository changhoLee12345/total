package co.micol.myweb.common;

public class PagingVO {
	private int startPage;
	private int endPage;
	private int totalCount;
	
	public PagingVO() {
		this.endPage = 10;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
}
