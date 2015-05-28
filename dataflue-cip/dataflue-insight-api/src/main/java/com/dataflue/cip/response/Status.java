package com.dataflue.cip.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Status {

	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
	
}
