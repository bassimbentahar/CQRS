package client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.core.MediaType;

import business.Acteur;
import business.Film;
import business.FilmDTO;
import business.Realisateur;
import restinterface.RestInterface;


public class UpdateFilms {
	private static final String URL_FILM_WRITER = "http://localhost:8080/CQRSFilmsWriter_cor/events/";
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");  

	public static void main(String[] args) {
		
		Acteur acteur =new Acteur("Blabla","Lambot");
		acteur.addLangue("Anglais");		
		Realisateur realisateur=new Realisateur("NomRealisateurAjoutee", "prenomRealisateurAjoutee");
		Film f = new Film(" Lambot 1", realisateur,acteur, "chinois","2017","Noc2017");
		Date dateToday = Calendar.getInstance().getTime(); 

		FilmDTO dto = new FilmDTO(f.getCote(),f.getNom(),f.getRealisateur().toString(),f.getActeurPrincipale().toString(),DATE_FORMAT.format(dateToday));
		
		// on envoie un POST car on cree une nouvelle ressource dans le serveur
		String newUrl=new RestInterface()
		.postRemoteObject(URL_FILM_WRITER,MediaType.APPLICATION_XML, FilmDTO.class,dto);
		
		System.out.println("Film mis à jour avec l'url: "+newUrl);

	}

}
