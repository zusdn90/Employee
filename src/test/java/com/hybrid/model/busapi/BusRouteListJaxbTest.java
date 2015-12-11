package com.hybrid.model.busapi;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class BusRouteListJaxbTest {
	
	public static void main(String[] args) {
		// JAXB (Java Architecture And Xml Binding)
		
		try{
			JAXBContext ctx = JAXBContext.newInstance(ServiceResult.class);
			
			ServiceResult result = new ServiceResult();
			Msgheader msgheader = new Msgheader();
			msgheader.setHeaderCd("100");
			msgheader.setHeaderMsg("정상처리...");
			msgheader.setItemCount(999);
			result.setMsgHeader(msgheader);
			
			/*
			 *  Marshal
			 */
			
			Marshaller marshaller = ctx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			marshaller.marshal(result, System.out);
			
			/*
			 * UnMarshal
			 */
			
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			
			String str = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList?strSrch=6628&serviceKey=tm3pW6%2F9PlIPDSa4e0xtnhB2r%2B4Mc0dwHL%2BLGhEQl8jZGIZaZTuNT9ABKnlGk72fc2PjVlLfvNj%2F4LjTxNmHBQ%3D%3D";
			
			URL url = new URL(str);
			ServiceResult busResult = (ServiceResult) unmarshaller.unmarshal(url);
			
			marshaller.marshal(busResult, System.out);
			
		}catch(JAXBException e)
		{
			e.printStackTrace();
		}catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		
		
	}
}
