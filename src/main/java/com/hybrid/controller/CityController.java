package com.hybrid.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.model.City;
import com.hybrid.model.CityList;
import com.hybrid.model.CityPage;
import com.hybrid.service.CityListService;
import com.hybrid.service.CityPageService;
import com.hybrid.util.Pagination;

@Controller						 // 자동등록을 위해서 component-scan
@RequestMapping("/city") 		// city라고 요청이 들어오면 컨트롤러가 요청을 담당
public class CityController {
	static Log  log = LogFactory.getLog(CityController.class);
	
//	@Autowired						//field 주입
	CityListService cityListService;
	
//	@Autowired
	CityPageService cityPageService;
	
	public void setCityListService(CityListService service)
	{
		this.cityListService = service;
	}
	
	public void setCityPageService(CityPageService service)
	{
		this.cityPageService = service;
	}
	
	
	
	@RequestMapping("/city.html")	// city.html 요청이 들어오면 getView가 실행가 실행되면서 /WEB-INF/view/city/city.jsp 이것이 실행된다.
	public String getView()
	{
		log.info("getView()...");
		
		return "city/city";		// 논리적인view로 취급하여 return	
								// (/WEB-INF/view/city/city.jsp) response
	}
	
	@RequestMapping(value={"","/"})		//data 요청
	@ResponseBody						//return한 값을 html body에 넣는다.
	public CityList getCityAll()
	{
		CityList list = cityListService.getList();
		

		return list;			//ResponseBody는 return을 data로 취급 
	}
	
	//@RequestMapping("/page/{pageNo:[\\-\\+]{0,1}[0-9]+}")	//+의 의미는 앞자리를 한번이상 반복한다는 의미 
	@RequestMapping("/page/{pageNo:[0-9]+}")	 
	@ResponseBody		//json,xml로 return 받기 위해 사용
	public CityPage getCityPage(@PathVariable int pageNo)
	{
		log.info("pageNo = " + pageNo);
		CityPage page = cityPageService.getPage(pageNo);
		
		return page;
	}
}
