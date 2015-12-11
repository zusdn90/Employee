package com.hybrid.model.busapi;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//JAXB 어노테이션
@XmlRootElement(name="ServiceResult")	//JAXB가 소문자로 인식하므로 name값을 ServiceResult 지정해줘야한다.
@XmlType(propOrder={"msgHeader","msgBody"})	//순서를 정할수 있다 


public class ServiceResult {
	Msgheader msgHeader;
	MsgBody msgBody;

	public MsgBody getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(MsgBody msgBody) {
		this.msgBody = msgBody;
	}

	public Msgheader getMsgHeader() {
		return msgHeader;
	}

	public void setMsgHeader(Msgheader msgHeader) {
		this.msgHeader = msgHeader;
	}
	
}
