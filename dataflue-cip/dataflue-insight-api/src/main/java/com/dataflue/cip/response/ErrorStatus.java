package com.dataflue.cip.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * 
 * ErrorStatus Builder for creating response builder for ErrorStatus and ErrorStatus handling
 * conditions
 * 
 * @author Vishnu Sankar
 * @since 1.0
 * 
 */
@XmlRootElement(name="errorStatus")
public class ErrorStatus{

	@XmlElement(name = "errorStatuscode")
	private String errorStatusCode;

	@XmlElement(name = "errorStatusmessage")
	private String errorStatusMessage;
	
	/**
	 * 
	 */
	public ErrorStatus() {
	};

	/**
	 * 
	 * @param ErrorStatusCode
	 * @param ErrorStatusMessage
	 */
	public ErrorStatus(String errorStatusCode, String errorStatusMessage) {
		this.errorStatusCode = errorStatusCode;
		this.errorStatusMessage = errorStatusMessage;
	}
	
	/**
	 * To return response in JSON format({"a":"b"})
	 * 
	 */
	@Override
	public String toString() {
		try {
			return new JSONObject().put("errorStatusCode", errorStatusCode)
					.put("errorStatusMessage", errorStatusMessage).toString();
		} catch (JSONException e) {
			return null;
		}
	}
}
