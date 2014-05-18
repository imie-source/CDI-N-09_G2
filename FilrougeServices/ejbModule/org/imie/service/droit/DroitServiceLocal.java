package org.imie.service.droit;

import java.util.List;

import javax.ejb.Local;

import model.Droit;

@Local
public interface DroitServiceLocal {
	public List<Droit> rechercherDroit(Droit droit);
	public Droit creerDroit(Droit droit);
	public Droit mettreAJourDroit(Droit droit);
	public void supprimerDroit(Droit droit);

}
