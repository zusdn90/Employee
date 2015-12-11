package com.hybrid.controller;

import java.net.URLDecoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.hybrid.model.busapi.ServiceResult;

//Spring 어노테이션 
@Controller
@RequestMapping("/busRouteInfo") // 외부에서 접근하기 위해서 맵핑처리
public class BusRouteListController {
	static Log log = LogFactory.getLog(BusRouteListController.class);

	@RequestMapping("/getBusRouteList/{strSrch}")
	@ResponseBody	//return 타입이 객체면 마샬링 시켜서 리턴
	public ServiceResult getBusRouteList(@PathVariable String strSrch) {
		log.info("getBusRouteList().. strSrch = " + strSrch);

		RestTemplate rest = new RestTemplate();

		String url = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList?strSrch={strSrch}&serviceKey={serviceKey}";
		String serviceKey = URLDecoder.decode(
				"tm3pW6%2F9PlIPDSa4e0xtnhB2r%2B4Mc0dwHL%2BLGhEQl8jZGIZaZTuNT9ABKnlGk72fc2PjVlLfvNj%2F4LjTxNmHBQ%3D%3D");

		//외부의 데이터를 자바객체로 unmashaling하는 과정 
		ServiceResult result = rest.getForObject(url, ServiceResult.class, strSrch, serviceKey);
		
		return result;		//mashaling된 결과를 리턴
	}
}
