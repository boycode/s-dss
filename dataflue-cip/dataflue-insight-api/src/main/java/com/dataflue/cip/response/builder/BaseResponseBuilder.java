package com.dataflue.cip.response.builder;

import java.util.List;

import org.apache.log4j.Logger;

import com.dataflue.cip.enums.ErrorStatusMessageEnum;
import com.dataflue.cip.response.ErrorStatus;

/**
 * Generic Format builder for the API . In this layer mainly the response object
 * creation happens also in this layer primary validation will also happens
 * 
 * @author Vishnu.Sankar
 * @version 1.0
 * 
 * 
 */
public abstract class BaseResponseBuilder {

	private static Logger LOGGER = Logger.getLogger(BaseResponseBuilder.class);

	/**
	 * CIP Platform ErrorStatus Builders Messages for Content Building exception
	 * 
	 * @param e
	 * @return String
	 */
	protected String getContentBuildingErrorStatusMessage(Exception e) {
		ErrorStatus ErrorStatus = new ErrorStatus(
				ErrorStatusMessageEnum.CONTENT_BUILDING_EXCEPTION.getCode()
						.toString(),
				ErrorStatusMessageEnum.CONTENT_BUILDING_EXCEPTION.getMessage());
		LOGGER.error(
				ErrorStatusMessageEnum.CONTENT_BUILDING_EXCEPTION.getMessage(),
				e);
		return ErrorStatus.toString();
	}

	/**
	 * Platform ErrorStatus Builders Messages for null pointer exception
	 * 
	 * @return String
	 */
	protected String getNullPointerErrorStatusMessage() {
		ErrorStatus ErrorStatus = new ErrorStatus(
				ErrorStatusMessageEnum.NULLPOINTER_EXCEPTION_MESSAGE.getCode()
						.toString(),
				ErrorStatusMessageEnum.NULLPOINTER_EXCEPTION_MESSAGE
						.getMessage());
		LOGGER.error(ErrorStatusMessageEnum.NULLPOINTER_EXCEPTION_MESSAGE
				.getMessage());
		return ErrorStatus.toString();
	}

	/**
	 * To convert List of collection into JSON object
	 * 
	 * @param <T>
	 * @param toJson
	 * @return
	 */
	protected <T> String toCollectionJsonify(List<T> toJson) {
		return toJson.toString();
	}

	/**
	 * To convert String into JSON object
	 * 
	 * @param <T>
	 * @param toJson
	 * @return
	 */
	protected <T> String toStringJsonify(T toJson) {
		return toJson.toString();
	}

}
