package com.dataflue.cip.enums;

import com.dataflue.cip.utils.Messages;


/**
 * This Enum Populates and Maps the Exception Error Code with the Error Messages
 * @author Vishnu Sankar
 * @version 1.0
 *
 */
public enum ErrorStatusMessageEnum {

	RUN_TIME_EXCEPTION(1000,Messages.RUN_TIME_EXCEPTION_MESSEAGE),
	SERVICE_NOT_AVAILABLE(1001,Messages.SERVICE_NOT_AVAILABLE_MESSEAGE),	
	API_SERVICE_EXCEPTION(1002,Messages.API_SERVICE_EXCEPTION),
	NULLPOINTER_EXCEPTION_MESSAGE(1003,Messages.NULLPOINTER_EXCEPTION_MESSAGE),	
	AUTH_FAILED_MESSAGE(1004,Messages.AUTH_FAILED_MESSAGE),	
	CONTENT_BUILDING_EXCEPTION(1005,Messages.CONTENT_BUILDING_EXCEPTION_MESSAGE);
	
	
	private Integer code;
	private String message;
	/**
	 * 
	 * @param code
	 * @param message
	 */
	private ErrorStatusMessageEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	/**
	 * 
	 * @return code
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * 
	 * @return message
	 */
	public String getMessage() {
		return message;
	}
}
