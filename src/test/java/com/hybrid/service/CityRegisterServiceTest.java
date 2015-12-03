package com.hybrid.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.exception.CityRegisterException;
import com.hybrid.model.City;

public class CityRegisterServiceTest {

	static Log log = LogFactory.getLog(CityRegisterServiceTest.class);
	
	public static void main(String[] args) {
		GenericApplicationContext ctx = null;
		
		ctx = new GenericXmlApplicationContext("spring/beans_service.xml",
												"spring/beans_dao.xml");
		
		CityRegisterService service = ctx.getBean(CityRegisterService.class);
		
		City city = new City();
		city.setName("bootstrap");
		city.setCountryCode("web");
		city.setDistrict("css framework");
		city.setPopulation(1200000);
		
		try{
			int id = service.regist(city); 			//insert시 예외처리 메소드 호출
			log.info("city regist id = " + id);		//controller에서 구현 
		}catch(CityRegisterException e)
		{
			log.error("city register error...", e);
		}
		ctx.close();
	}

}
