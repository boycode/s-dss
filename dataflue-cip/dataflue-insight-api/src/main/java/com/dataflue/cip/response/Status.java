package com.dataflue.cip.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Vishnu sankar
 *
 */
@XmlRootElement
public class Status {

	private String code;
	/**
	 * 
	 */
	private String message;

	/**
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
