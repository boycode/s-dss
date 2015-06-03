package com.dataflue.cip.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dataflue.cip.response.builder.RecommendationTagBuilder;

/**
 * Description TODO Generic Holder for the recommendation retrieval
 * 
 * @author Vishnu Sankar
 *
 */
@Component
@Path("/api")
public class RecommendationTagRetrive {

	@Autowired
	private RecommendationTagBuilder recommendationTagBuilder;

	/**
	 * Description TODO Any Arguments can be passed to the next tier.
	 * 
	 * Standard Format will define soon : Include- GET /POST Params with the
	 * Unique ID / DataModel / Limit
	 * 
	 * 
	 * @return Response
	 */
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePayment() {
		Object buildRecommendation = recommendationTagBuilder
				.buildRecommendation("Hello");
		return Response.status(200).entity(buildRecommendation).build();

	}

}