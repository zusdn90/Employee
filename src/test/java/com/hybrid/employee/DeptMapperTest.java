package com.hybrid.employee;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.DeptMapper;
import com.hybrid.model.Dept;

public class DeptMapperTest {
	
	static Log log = LogFactory.getLog(DeptMapperTest.class);
	public static void main(String[] args) {
		
		GenericApplicationContext ctx = 
				new GenericXmlApplicationContext("spring/beans_oracle.xml");
				
		
		DeptMapper deptMapper = ctx.getBean(DeptMapper.class);
		
		List<Dept> list = deptMapper.selectAll();
		
		list.forEach(new Consumer<Dept>() {

			@Override
			public void accept(Dept t) {
				log.info("deptno = " + t.getDeptno());
				log.info("dname = " + t.getDname());
				log.info("loc = " + t.getLoc());
			}
		});
			
		System.out.println();
		
		Dept dept = deptMapper.selectByDeptno(10);
				log.info("deptno = " + dept.getDeptno());
				log.info("dname = " + dept.getDname());
				log.info("loc = " + dept.getLoc());
	}
}
