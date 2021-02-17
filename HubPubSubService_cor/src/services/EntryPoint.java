package services;

import java.util.ArrayList;

import javax.servlet.http.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import business.SubscriberDTO;
import dto.SubscriberFileStorage;
import utils.*;

@Path("/")
public class EntryPoint {
	
	private static final String FILEPATH= EntryPoint.class.getClassLoader().getResource("subscribers.txt").getPath();

	@POST
	@Path("subscribers")
	@Consumes(MediaType.APPLICATION_XML)
	public void createBook(SubscriberDTO dto,@Context HttpServletResponse response, @Context UriInfo uriInfo)throws Exception{
		
		new SubscriberFileStorage().append(dto.toString(),FILEPATH);
		String baseURL = uriInfo.getBaseUri().toString();
		response.setStatus(HttpServletResponse.SC_CREATED);
		response.setHeader(HttpHeaders.LOCATION, baseURL+dto.getTopic()+dto.getUrl());
		try { response.flushBuffer(); }catch(Exception e){}
		}
	
	@PUT
	@Path("dispatcher/{topic}")
	@Produces(MediaType.APPLICATION_XML)
	public void dispatchEvent(String event,@PathParam("topic") String topic) throws Exception{
		
		ArrayList<String> urls = new SubscriberFileStorage().readAll(topic,FILEPATH);
		for(String url : urls) { 
			System.out.println(url);
			new ThreadedDispatcher(TypeRequest.POST,url,event, MediaType.APPLICATION_XML).start();
		}
	}
	
	@DELETE
	@Path("dispatcher/{topic}")
	public void dispatchEvent(@PathParam("topic") String topic) throws Exception{
		ArrayList<String> urls = new SubscriberFileStorage().readAll(topic,FILEPATH);
		for(String url : urls)
			new ThreadedDispatcher(TypeRequest.DELETE,url, MediaType.APPLICATION_XML).start();

	}
	
}
