package com.hybrid.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.command.CityCommand;
import com.hybrid.model.City;
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
   
   /*
    * main.html
    */
   @RequestMapping(value="/main.html" , method=RequestMethod.GET)   // main.html 요청이 들어오면 getMainView가 실행가 실행되면서 /WEB-INF/view/city/main.jsp 이것이 실행된다.
   public String getMainView()
   {
      log.info("getMainView()...");
      
      return "city/main";      // 논리적인view로 취급하여 return   
                        // (/WEB-INF/view/city/main.jsp) response
   }
   /*
    * list.html
    */
   @RequestMapping(value="/list.html",method=RequestMethod.GET)   // list.html 요청이 들어오면 getListView가 실행가 실행되면서 /WEB-INF/view/city/list.jsp 이것이 실행된다.
   public String getListView()
   {
      log.info("getListView()...");
      
      return "city/list";      // 논리적인view로 취급하여 return   
                        // (/WEB-INF/view/city/list.jsp) response
   }
   /*
    * detail.html
    */
   @RequestMapping(value="/detail.html",method=RequestMethod.GET)   // detail.html 요청이 들어오면 getDetailView가 실행가 실행되면서 /WEB-INF/view/city/detail.jsp 이것이 실행된다.
   public String getDetailView()
   {
      log.info("getDetailView()...");
      
      return "city/detail";      // 논리적인view로 취급하여 return   
                        // (/WEB-INF/view/city/detail.jsp) response
   }
   /*
    * append.html
    */
   @RequestMapping(value="/append.html",method=RequestMethod.GET)   // append.html 요청이 들어오면 getAppendView가 실행가 실행되면서 /WEB-INF/view/city/append.jsp 이것이 실행된다.
   public String getAppendView()
   {
      log.info("getAppendView()...");
      
      return "city/append";      // 논리적인view로 취급하여 return   
                        // (/WEB-INF/view/city/append.jsp) response
   }
   /*
    * append.html
    */
   @RequestMapping(value="/modify.html",method=RequestMethod.GET)   // modify.html 요청이 들어오면 getModifyView가 실행가 실행되면서 /WEB-INF/view/city/city.jsp 이것이 실행된다.
   public String getModifyView()
   {
      log.info("getModifyView()...");
      
      return "city/modify";      // 논리적인view로 취급하여 return   
                        // (/WEB-INF/view/city/modify.jsp) response
   }
   @RequestMapping(value="/delete.html",method=RequestMethod.GET)   // delete.html 요청이 들어오면 getDeleteView가 실행가 실행되면서 /WEB-INF/view/city/delete.jsp 이것이 실행된다.
   public String getDeleteView()
   {
      log.info("getDeleteView()...");
      
      return "city/delete";      // 논리적인view로 취급하여 return   
                        // (/WEB-INF/view/city/delete.jsp) response
   }
   /*
    *  GET_LIST = /city or /city/
    *  Accept = application/json
    */
   @RequestMapping(value={"","/"},method=RequestMethod.GET)      //data 요청
   @ResponseBody            //return한 값을 html body에 넣는다.
   public CityList getCityAll()
   {
      log.info("getCityAll()....");
      CityList list = cityListService.getList();
      
   
      
      
      return list;         //ResponseBody는 return을 data로 취급 
   }
   /*
    *    URL_GET_ITEM_BASE = [/city/{id}]
    *    Accept = application/json
    */
   @RequestMapping(value="/{id:[0-9]+}",method=RequestMethod.GET)
   @ResponseBody
   public City getCityItem(@PathVariable int id){
      log.info("getCityItem().... id = "+id);
      City city = new City();
      city.setId(id);
      city.setName("seoul");
      return city;
   }
   
   
   
   
//   @RequestMapping("/page/{pageNo:[\\-\\+]{0,1}[0-9]+}")
//   {0,1} 0번 또는 1번 실행
//   [\\-\\+] - + 부호를 나타내려고 \\사용해서 -와 + 표현
   
   /*
    *    URL_GET_PAGE = [/city/page/{pageNo}]
    *    Accept = application/json
    */
   @RequestMapping(value="/page/{pageNo:[0-9]+}",method=RequestMethod.GET)
   @ResponseBody//json or xml로 return받기위해
   public CityPage getCityPage(@PathVariable int pageNo){
      log.info("pageNo = " + pageNo);
      CityPage page = cityPageService.getPage(pageNo);
      
      return page;
   }
   /*
    *	URL_POST_ITEM_APPEND = [/city] or [/city/] 
    *	Accept = application/json
    */
   @RequestMapping(value={"","/"}, method=RequestMethod.POST)		//POST로 요청을 하면 입력으로 응답
   @ResponseBody
   public CityCommand postCityAppend(@RequestBody CityCommand city){
	      log.info("postCityAppend()... city.id = " + city.getId());
	   
	   return city;
   }
   
   /*
    *	URL_PUT_ITEM_MODIFY = [/city/{id}]  
    *	Accept = application/json
    */
   @RequestMapping(value={"/{id:[0-9]+}"}, method=RequestMethod.PUT)		
   @ResponseBody
   public CityCommand putCityModify(@PathVariable int id, @RequestBody CityCommand city){
	   log.info("putCityModify()... id = " + id);
	   log.info("putCityModify()... city.id = " + city.getId());
	   
	   return city;
   }
   
   /*
    *	URL_DELETE_ITEM_DELETE = [/city/{id}]  
    *	Accept = application/json
    */
   @RequestMapping(value={"/{id:[0-9]+}"}, method=RequestMethod.DELETE)		
   @ResponseBody
   public CityCommand deleteCity(@PathVariable int id){
	   log.info("deleteCity()... id = " + id);
	   CityCommand city = new CityCommand();
	   city.setId(id);
	   
	   return city;
   }
   
   
   
}