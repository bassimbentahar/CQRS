package client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.*;

import business.*;
import restinterface.*;


public class Savefilms {//SaveFilms
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");  
	private static final String URL_FILMS_WRITER = "http://localhost:8080/CQRSFilmsWriter_cor/events/";
	
	
	public static void main(String[] args) throws Exception {
		
		Savefilms initializeDataFilmsClient=new Savefilms();
		
		List<Film> films=initializeDataFilmsClient.initializeFilms();
		
		initializeDataFilmsClient.sendDTOs(films);
					

	}
	
	private void sendDTOs(List<Film> films) {
		Date dateToday = Calendar.getInstance().getTime(); 

		films.forEach(f->{
						
			FilmDTO dto = new FilmDTO(f.getCote(),f.getNom(),f.getRealisateur().toString(),f.getActeurPrincipale().toString(),DATE_FORMAT.format(dateToday));
			
			
			String newUrl=new RestInterface()
				.postRemoteObject(URL_FILMS_WRITER,MediaType.APPLICATION_XML, FilmDTO.class,dto);
			System.out.println("Film créé avec l'url: "+newUrl);
		});
		
	}
	private List<Film> initializeFilms(){
		 List<Film> films = new ArrayList<>();

		Acteur acteur =new Acteur("Amy","Adams");
		acteur.addLangue("Anglais");		
		Realisateur realisateur=new Realisateur("Tom", "Ford");
		Film film = new Film("Nocturnal Animals", realisateur,acteur, "Anglais","2017","Noc2017");
		films.add(film);
		
		acteur =new Acteur("Javier","Badrem");
		acteur.addLangue("Anglais");	
		acteur.addLangue("Espagnol");
		realisateur=new Realisateur("Sean", "Penn");
		film = new Film("The Last Face", realisateur,acteur, "Anglais","2017","The2017");
		films.add(film);
		
		acteur =new Acteur("Deborah","Francois");
		acteur.addLangue("Francais");		
		realisateur=new Realisateur(" Stephanie", "Pillonca-Kervern");
		film = new Film("Fleur de Tonnerre", realisateur, acteur,"Francais","2017","Fle2017");
		films.add(film);

		acteur =new Acteur("Vin","Diesel");
		acteur.addLangue("Anglais");		
		realisateur=new Realisateur("D.J", "Caruso");
		film = new Film("XxX : Reactivated", realisateur,acteur, "Anglais","2017","XxX2017");
		films.add(film);
		
		acteur =new Acteur("Matthew ","McConaughey");
		acteur.addLangue("Anglais");		
		realisateur=new Realisateur("Garth", "Jennings");
		film = new Film("Tous en scene", realisateur,acteur, "Anglais","2017","Tou2017");
		films.add(film);
		
		return films;
	}
}
