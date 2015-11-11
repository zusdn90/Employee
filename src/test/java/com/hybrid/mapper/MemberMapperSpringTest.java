package com.hybrid.mapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.model.Member;

public class MemberMapperSpringTest {

	static Log log = LogFactory.getLog(MemberMapperSpringTest.class);

	public static void main(String[] args) throws SQLException {

		// test1();
		// test2();
			
			
			GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml");
			
			MemberMapper memberMapper = ctx.getBean(MemberMapper.class);
			
			List<Member> list = memberMapper.selectAll();
			
			list.forEach(new Consumer<Member>()
			{
				public void accept(Member t) {
					log.info("email = " + t.getEmail());
				}
			});
	}
	
	static void test2(){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml");

		SqlSessionFactory sqlSessionFactory = ctx.getBean(SqlSessionFactory.class);
		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<Member> list = sqlSession.selectList("com.hybrid.mapper.MemberMapper.selectAll");
		
		list.forEach(new Consumer<Member>()
		{
			public void accept(Member m) {
				log.info("id = " + m.getId());
			}
			
		});

	}

	static void test1() throws SQLException {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml");

		// BasicDataSource dataSource = (BasicDataSource)
		// ctx.getBean("oracleDataSource");

		BasicDataSource dataSource = ctx.getBean("dataSource", BasicDataSource.class);
		log.info(ctx);
		log.info(dataSource.getUsername());
		log.info(dataSource.getPassword());
		log.info("classname = " + dataSource.getDriverClassName());
		log.info("url = " + dataSource.getUrl());

		Connection con = dataSource.getConnection();
		String productName = con.getMetaData().getDatabaseProductName();
		log.info(productName);
		String productVersion = con.getMetaData().getDatabaseProductVersion();
		log.info(productVersion);

	}
}