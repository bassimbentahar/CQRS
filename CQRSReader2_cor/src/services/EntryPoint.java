package services;



import javax.servlet.http.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import dto.*;

@Path("/")
public class EntryPoint {
	
	// path du fichier filmReades2.txt
	static final private String FILE_PATH= EntryPoint.class.getClassLoader().getResource("filmsReader2.txt").getPath();

	//enregistre l'event recu 
	@POST
	@Path("events")
	@Consumes(MediaType.APPLICATION_XML)
	public void storeEvent(String event,@Context UriInfo uriInfo, @Context HttpServletResponse response)throws Exception{
		if(FILE_PATH.trim().length()==0) throw new WebApplicationException(500);
		
		new FileStorage().append(event,FILE_PATH);

		response.setStatus(HttpServletResponse.SC_CREATED);
		try { response.flushBuffer(); }catch(Exception e){}
		
		}
	
	//retrouve le dernier event ayant cet id
	@GET
	@Path("events/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String getEvent(@PathParam("id") String id)throws Exception{
		if(FILE_PATH.trim().length()==0) throw new WebApplicationException(500);
		
		
		String result = new FileStorage().getFilmById(id,FILE_PATH);
		
		if(result == null)
			throw new WebApplicationException(404);
		return result;
	}
	
	@DELETE
	@Path("events")
	public void deleteAllEvents()throws Exception{
		if(FILE_PATH.trim().length()==0) throw new WebApplicationException(500);;
		new FileStorage().rewrite(FILE_PATH);
	}
	
}
