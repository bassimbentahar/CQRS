package services;


import javax.servlet.http.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import dto.FileStorage;
import restinterface.RestInterface;

@Path("/")
public class EntryPoint {

	//path du fichier filmsWriter.txt (dans le serveur)
	private static final String FILE_PATH= EntryPoint.class.getClassLoader().getResource("filmsWriter.txt").getPath();
	private static final String URL_PUBHUB = "http://localhost:8080/HubPubSubService_cor/dispatcher/film";


	//enregistre l'event recu 
	@POST
	@Path("events")
	@Consumes(MediaType.APPLICATION_XML)
	public void storeEvent(String event,@Context UriInfo uriInfo, @Context HttpServletResponse response)throws Exception{
		if(FILE_PATH.trim().length()==0)
			throw new WebApplicationException(500);
		new FileStorage().append(event,FILE_PATH);
		
		System.out.println("ecriture dans une BDD locale(fichier filmsWriter.txt )....");
		
		String id = new FileStorage().getId(event);
		String baseURL = uriInfo.getBaseUri().toString();
		response.setHeader(HttpHeaders.LOCATION, baseURL+"/"+id);

		response.setStatus(HttpServletResponse.SC_CREATED);
		try { response.flushBuffer(); }catch(Exception e){}

		//envoyer au Hub pour enregister dans les readers inscrit pour la topic film passee en parametres 
		new RestInterface().putRemoteObject(URL_PUBHUB,MediaType.APPLICATION_XML, event);

	}

	@DELETE
	@Path("events")
	public void deleteEvent(@Context UriInfo uriInfo, @Context HttpServletResponse response)throws Exception{
		System.out.println("effacer les donnees locales du writer et envoyer une requete pour effacer dans les readers");
		if(FILE_PATH.trim().length()==0)
			return;
		new FileStorage().rewrite(FILE_PATH);

		// effacer aussi les services reader

		new RestInterface().deleteAllRemoteObject(URL_PUBHUB);
	}

}
