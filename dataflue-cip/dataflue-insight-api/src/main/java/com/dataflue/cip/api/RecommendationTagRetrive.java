package com.dataflue.cip.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dataflue.cip.response.Status;
import com.dataflue.cip.services.impl.GenericTagRetrivalService;
/**
 * Description TODO
 * 
 * @author Vishnu Sankar
 *
 */
@Component
@Path("/api")
public class RecommendationTagRetrive {

	@Autowired
	GenericTagRetrivalService tagRetrivalService;
	
	/**
	 *  Description TODO
	 *  
	 * @return Response
	 */
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePayment() {
		String result = tagRetrivalService.returnRecommendationTag();
		Status status = new Status();
		status.setCode("1000");
		status.setMessage("Insight Provider : Successful Recommendation Tag Generated" +result);
		return Response.status(200).entity(status).build();

	}

}