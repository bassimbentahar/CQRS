package business;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class FilmDTO {

	private String nomFilm;
	private String nomRealisateur;
	private String nomActeurPrincipal;
	private String date;
	

	public FilmDTO(String id,String nomFilm, String nomRealisateur, String nomActeurPrincipal, String date) {
		super();
		this.id=id;
		this.nomFilm = nomFilm;
		this.nomRealisateur = nomRealisateur;
		this.nomActeurPrincipal = nomActeurPrincipal;
		this.date = date;
	}
	
	public FilmDTO() {
	}

	private String id;
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNomFilm() {
		return nomFilm;
	}


	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}


	public String getNomRealisateur() {
		return nomRealisateur;
	}


	public void setNomRealisateur(String nomRealisateur) {
		this.nomRealisateur = nomRealisateur;
	}


	public String getNomActeurPrincipal() {
		return nomActeurPrincipal;
	}


	public void setNomActeurPrincipal(String nomActeurPrincipal) {
		this.nomActeurPrincipal = nomActeurPrincipal;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	
	public String toString(){
		return "Nom Du film: "+nomFilm+", Nom du realisateur: "+nomRealisateur+", Nom de l'acteur principal:"+nomActeurPrincipal+" Date: "+date;
	}
}
