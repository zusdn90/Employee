package com.hybrid.util;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;

public class PaginationTest {

	public static void main(String[] args) {
		GenericApplicationContext ctx = null;
		ctx = new GenericXmlApplicationContext("spring/beans_mysql.xml");
		
		CityMapper cityMapper = ctx.getBean(CityMapper.class);
		int totalItem = cityMapper.selectCount();
		System.out.println("totalItem = " + totalItem);
		
		
		Pagination paging = new Pagination();
		Scanner sc = new Scanner(System.in);
		
		while(true){
			
		System.out.println("pageNo = ");	
		int pageNo = sc.nextInt();
		
		paging.setPageNo(pageNo);
		paging.setTotalItem(totalItem);
		System.out.println(paging.getLength());
		List<City> list = cityMapper.selectPage(paging);
		
//		for(int i=0; i<paging.getLength();i++)
//		{
//			City c = list.get(i);
		
		for(int i=paging.getFirstItem(); i<paging.getLastItem();i++)
		{
			City c = list.get(i - paging.getFirstItem());
			String line = c.getId()+ " "+ c.getName() + " " + c.getCountryCode();
			System.out.println(line);
		}
		
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
