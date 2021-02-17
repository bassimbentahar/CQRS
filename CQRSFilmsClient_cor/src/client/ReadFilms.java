package client;


import javax.ws.rs.core.MediaType;

import business.*;
import restinterface.*;


public class ReadFilms {
	private static final String URL_FILM_FROM_READER_1 = "http://localhost:8080/CQRSReader_cor/events/Noc2017";
	private static final String URL_FILM_FROM_READER_2 = "http://localhost:8080/CQRSReader2_cor/events/Noc2017";
	
	public static void main(String[] args) throws Exception {
				
		FilmDTO filmDtoFromReader1 = (FilmDTO)new RestInterface()
			.getRemoteObject(URL_FILM_FROM_READER_1,MediaType.APPLICATION_XML, FilmDTO.class);
		
		System.out.println("Service_reader 1");
		System.out.println(filmDtoFromReader1);
		
		FilmDTO filmDtoFromReader2 = (FilmDTO)new RestInterface()
				.getRemoteObject(URL_FILM_FROM_READER_2,MediaType.APPLICATION_XML, FilmDTO.class);
		
		System.out.println("Service_reader 2");
		System.out.println(filmDtoFromReader2);
		

	}
}
