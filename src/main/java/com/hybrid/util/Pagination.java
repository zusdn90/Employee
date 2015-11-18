package com.hybrid.util;

public class Pagination {
	
	private int totalItem;
	private int	pageNo;
	
	/*
	 * read-write
	 */
	
	private int totalPage;
	private int firstItem;
	private int lastItem;
	private int firstPage;
	private int lastPage;
	
	/*
	 * read-write
	 */
	
	private int itemsPerPage = 10;
	private int pagesPerGroup = 10;
	
	public void calculate()
	{
		/*
		 *  pageNo validation
		 */
		
		if(pageNo < 1)
			pageNo = 1;
		
		/*
		 * totalPage
		 */
		//4079 / 10 = 407 			==> 408
		//4079 % 10 >0 407++		==>408
		
		totalPage = totalItem / itemsPerPage;
		if(totalItem % itemsPerPage > 0)
			totalPage++;
		/*
		 * pageNo validation
		 */
		
		if(pageNo > totalPage)
			pageNo = (totalPage == 0) ? 1 : totalPage;
		
		
		/*
		 * firstItem 
		 */
		// (1-1) * 10 + 1 = 1		==> 1
		// (5-1) * 10  + 1 = 41		==> 41 
		firstItem = (pageNo - 1) * itemsPerPage + 1;
		
		/*firstItem = 4071
		 * lastItem = 4079
		 * 
		 * lastItem = 4071 + 10 -1 = 4080
		 */
		lastItem = firstItem + itemsPerPage -1;
		if(lastItem > totalItem)
			lastItem = totalItem;
		
		/*
		 *firstPage =  
		 */
		// pageNo =5	==>	firstPage = 1
		// (5-1)/10*10 + 1 = 1
		//	(16-1)/10*10 + 1 = 11
		// (408-1)/10*10 +1 = 401
		firstPage = (pageNo - 1) / pagesPerGroup * pagesPerGroup + 1;
		
		/*
		 *  lastPage
		 */
		lastPage = firstPage + (pagesPerGroup - 1);
		if(lastPage > totalPage)
			lastPage = totalPage;
	}
	
	
	public int getTotalItem() {
		return totalItem;
	}
	public int getPageNo() {
		return pageNo;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getFirstItem() {
		return firstItem;
	}
	public int getLastItem() {
		return lastItem;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public int getItemsPerPage() {
		return itemsPerPage;
	}
	public int getPagePerGroup() {
		return pagesPerGroup;
	}
	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
		/*
		 * 유도 변수들을 계산한다.
		 */
		
		calculate();
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}
	public void setPagePerGroup(int pagesPerGroup) {
		this.pagesPerGroup = pagesPerGroup;
	}
	
	public boolean isFirstGroup()
	{
		return (firstPage == 1) ? true : false; 
	}
	public boolean isLastGroup()
	{
		return (lastPage == totalPage) ? true : false;
	}
	
}
