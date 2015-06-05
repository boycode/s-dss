/**
 * 
 */
package com.dataflue.cip.response.builder;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dataflue.cip.response.Status;
import com.dataflue.cip.services.impl.GenericTagRetrivalService;

/**
 * TODO Generic builder for generating the recommendation tags
 * 
 * @author vishnu sankar
 *
 */
@Component
public class RecommendationTagBuilder extends BaseResponseBuilder {

	public static final Logger LOGGER = Logger
			.getLogger(RecommendationTagBuilder.class);

	@Autowired
	GenericTagRetrivalService tagRetrivalService;

	/**
	 * TODO Any thing can be passed as argument, Say Unique Id /RegressionType
	 * etc
	 * 
	 * Create the response Object backed from Java Object . Can be considered as
	 * the generic extended tier for building the JSON / XML
	 * 
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T buildRecommendation(T t) {
		Status status = new Status();
		try {
			String result = tagRetrivalService.returnRecommendationTag();
			status.setCode("1000");
			status.setMessage("Insight Provider : Successful Recommendation Tag Generated"
					+ result);
		} catch (Exception e) {
			String contentBuildingErrorStatusMessage = getContentBuildingErrorStatusMessage(e);
			LOGGER.error(contentBuildingErrorStatusMessage, e);
			return (T) contentBuildingErrorStatusMessage;

		}

		return (T) status;
	}

}
