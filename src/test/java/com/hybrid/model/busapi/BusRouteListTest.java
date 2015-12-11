package com.hybrid.model.busapi;

import java.net.URLDecoder;

import org.springframework.web.client.RestTemplate;

public class BusRouteListTest {

	public static void main(String[] args) {
		
		RestTemplate rest = new RestTemplate();
		
		String url = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList?strSrch={strSrch}&serviceKey={serviceKey}";
		String strSrch = "6628";
		String serviceKey = URLDecoder.decode("tm3pW6%2F9PlIPDSa4e0xtnhB2r%2B4Mc0dwHL%2BLGhEQl8jZGIZaZTuNT9ABKnlGk72fc2PjVlLfvNj%2F4LjTxNmHBQ%3D%3D");
		
//		String result = rest.getForObject(url, String.class, strSrch , serviceKey);
		ServiceResult result = rest.getForObject(url, ServiceResult.class, strSrch, serviceKey);
		
		System.out.println(result.getMsgHeader().getHeaderMsg());		//unmashaling
		
		System.out.println(result.getMsgBody().getItemList().get(0).getBusRouteId());
		
	}

}
