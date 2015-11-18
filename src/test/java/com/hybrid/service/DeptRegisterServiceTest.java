package com.hybrid.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.model.Dept;
import com.hybrid.model.Emp;

public class DeptRegisterServiceTest {

	static Log log = LogFactory.getLog(DeptRegisterServiceTest.class);
	
	public static void main(String[] args) {
		GenericApplicationContext ctx = null;
		
		ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml");
		
		DeptRegisterService service = ctx.getBean(DeptRegisterService.class);
	
		Dept dept = ctx.getBean(Dept.class);
		
		service.regist(dept);
	}

}
