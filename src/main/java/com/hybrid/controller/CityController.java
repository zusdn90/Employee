package com.hybrid.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.model.CityList;
import com.hybrid.model.CityPage;
import com.hybrid.service.CityListService;
import com.hybrid.service.CityPageService;

@Controller
@RequestMapping("/city")       // city라고 요청이 들어오면 컨트롤러가 요청을 담당
public class CityController {
   static Log  log = LogFactory.getLog(CityController.class);
   
   @Autowired
   CityListService cityListService;
   
   
   //Autowired는 어노테이션 형태로 database xml파일에 property등록을 안해도 가능 자동으로 
   //public void setCityPagegService(CityPageService city){
   //   this.cityPageService = city
   //}
   //이것을 표현한 것이다
   @Autowired
   CityPageService cityPageService;
   
   @RequestMapping("/main.html")   // main.html 요청이 들어오면 getMainView가 실행가 실행되면서 /WEB-INF/view/city/main.jsp 이것이 실행된다.
   public String getMainView()
   {
      log.info("getMainView()...");
      
      return "city/main";      // 논리적인view로 취급하여 return   
                        // (/WEB-INF/view/city/main.jsp) response
   }
   
   @RequestMapping("/list.html")   // list.html 요청이 들어오면 getListView가 실행가 실행되면서 /WEB-INF/view/city/list.jsp 이것이 실행된다.
   public String getListView()
   {
      log.info("getListView()...");
      
      return "city/list";      // 논리적인view로 취급하여 return   
                        // (/WEB-INF/view/city/list.jsp) response
   }
   @RequestMapping("/detail.html")   // detail.html 요청이 들어오면 getDetailView가 실행가 실행되면서 /WEB-INF/view/city/detail.jsp 이것이 실행된다.
   public String getDetailView()
   {
	   log.info("getDetailView()...");
	   
	   return "city/detail";      // 논리적인view로 취급하여 return   
	   // (/WEB-INF/view/city/detail.jsp) response
   }
   
   @RequestMapping(value={"","/"})      //data 요청
   @ResponseBody            //return한 값을 html body에 넣는다.
   public CityList getCityAll()
   {
      CityList list = cityListService.getList();
   
      return list;         //ResponseBody는 return을 data로 취급 
   }
   
   
//   @RequestMapping("/page/{pageNo:[\\-\\+]{0,1}[0-9]+}")
//   {0,1} 0번 또는 1번 실행
//   [\\-\\+] - + 부호를 나타내려고 \\사용해서 -와 + 표현
   @RequestMapping("/page/{pageNo:[0-9]+}")
   @ResponseBody//json or xml로 return받기위해
   public CityPage getCityPage(@PathVariable int pageNo){
      log.info("pageNo = " + pageNo);
      CityPage citys = cityPageService.getPage(pageNo);
      
      return citys;
   }
   
}