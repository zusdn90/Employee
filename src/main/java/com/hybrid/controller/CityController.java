package com.hybrid.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.model.City;
import com.hybrid.model.CityList;

@Controller
@RequestMapping("/city") 		// city라고 요청이 들어오면 컨트롤러가 요청을 담당
public class CityController {
	static Log  log = LogFactory.getLog(CityController.class);
	
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
		CityList list = new CityList();
		
		List<City> citys = new ArrayList<>();
		City city = new City();
		city.setId(100);
		city.setName("seoul");
		citys.add(city);
		
		
		City city2 = new City();
		city2.setId(200);
		city2.setName("busan");
		citys.add(city2);
		
		list.setCitys(citys);
		
		return list;			//ResponseBody는 return을 data로 취급 
	}
}
