package com.hybrid.util;

import java.util.Scanner;

public class PaginationTest {

	public static void main(String[] args) {
		Pagination paging = new Pagination();
		Scanner sc = new Scanner(System.in);
		
		while(true){
			
		System.out.println("pageNo = ");	
		int pageNo = sc.nextInt();
		paging.setPageNo(pageNo);
		paging.setTotalItem(4076);
		
		
		for(int i=paging.getFirstItem();i<=paging.getLastItem();i++)
			System.out.println("item index = " + i);
		
		if(!paging.isFirstGroup())
			System.out.printf("[이전] ");
		else
			System.out.println("       ");
		
		for(int i=paging.getFirstPage();i<=paging.getLastPage();i++)
		{
			System.out.printf("[%03d] ",i);
		}
		
		if(!paging.isLastGroup())
			System.out.println("[다음] ");
		else
			System.out.println("       ");
		
		System.out.println();
		}		
	}
	
	
	
	static void test1()
	{
		Pagination paging = new Pagination();
		
		for(int i =1; i < 13; i++){
			paging.setPageNo(i);
			paging.setTotalItem(120);
			
			String line = "totalPage = " + paging.getTotalPage()
						 + ",firstGroup = " + paging.isFirstGroup() 
						 + ",firstItem = " + paging.getFirstItem()
						 + ",lastItem = " + paging.getLastItem()
						 + ",pageNo = " + paging.getPageNo()
						 + ",firstPage = " + paging.getFirstPage()
						 + ",lastPage = " + paging.getLastPage()
						 + ",lastGroup = " + paging.isLastGroup();
			
			System.out.println(line);
		}
	}

}
