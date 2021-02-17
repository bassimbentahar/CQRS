package business;

import java.util.ArrayList;

public class Acteur extends Personne {
	private ArrayList<String> langues=new ArrayList<>();
	public Acteur(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

	
	public ArrayList<String> getLangues() {
		return langues;
	}
	public void setLangues(ArrayList<String> langues) {
		this.langues = langues;
	}

	public void addLangue(String langue) {
		langues.add(langue);
	}

}
