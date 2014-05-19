package org.imie.service;

import java.util.List;

import javax.ejb.Local;

import model.Projet;

@Local
public interface ProjetServiceLocal {
	public List<Projet> rechercherProjet(Projet projet);
	public Projet creerProjet(Projet projet);
	public Projet mettreAJourProjet(Projet projet);
	public void supprimerProjet(Projet projet);

}
