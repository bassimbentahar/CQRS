package business;


public class Film {
	private String nom;
	private Realisateur realisateur;
	private Acteur acteurPrincipale;
	private String langue;
	private String annee;
	private String cote;

	public Film(String nom, Realisateur realisateur, Acteur acteurPrincipale, String langue, String annee,String cote) {
		super();
		this.nom = nom;
		this.realisateur = realisateur;
		this.acteurPrincipale = acteurPrincipale;
		this.langue = langue;
		this.annee = annee;
		this.cote = cote;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Realisateur getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(Realisateur realisateur) {
		this.realisateur = realisateur;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public String getCote() {
		return cote;
	}
	public void setCote(String cote) {
		this.cote = cote;
	}
	public Acteur getActeurPrincipale() {
		return acteurPrincipale;
	}
	public void setActeurPrincipale(Acteur acteurPrincipale) {
		this.acteurPrincipale = acteurPrincipale;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	} 
	
	
	
}
