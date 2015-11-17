package com.hybrid.bean;

import java.io.IOException;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.hybrid.model.Member;

public class BeanCreateTest {

	static Log log = LogFactory.getLog(BeanCreateTest.class);
	static GenericApplicationContext ctx = null;

	public static void main(String[] args)
			throws InterruptedException, ParserConfigurationException, SAXException, IOException {

		ctx = new GenericXmlApplicationContext("com/hybrid/bean/beans.xml");

		// test1();

		Document document = ctx.getBean(Document.class);
		
		Element root = document.getDocumentElement();
		log.info(root.getNodeName());
	}

	static void test2() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = f.newDocumentBuilder();
		ClassPathResource resource = new ClassPathResource("com/hybrid/bean/dept.xml");

		Document document = builder.parse(resource.getInputStream());
		Element root = document.getDocumentElement();
		log.info(root.getNodeName());

	}

	static void test1() throws InterruptedException {
		Date d = ctx.getBean(Date.class);
		log.info("date = " + d);

		Thread.sleep(2000);

		Date d2 = ctx.getBean(Date.class);
		log.info("date = " + d2);

		Member m = ctx.getBean(Member.class);
		Member m2 = ctx.getBean(Member.class);

		m.setId(100);
		m.setEmail("xxx@yyy.com");

		log.info("id = " + m.getId());
		log.info("email = " + m.getEmail());
	}

}
