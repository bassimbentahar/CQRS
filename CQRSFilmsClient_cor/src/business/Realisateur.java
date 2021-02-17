package business;

import java.util.ArrayList;

public class Realisateur extends Personne {
	private ArrayList<Film> filmsRealises=new ArrayList<>();
	public Realisateur(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}
	public void setFilms(ArrayList<Film> filmsRealises) {
		this.filmsRealises = filmsRealises;
	}
	
	public void addFilm(Film film) {
		filmsRealises.add(film);
	}
}
