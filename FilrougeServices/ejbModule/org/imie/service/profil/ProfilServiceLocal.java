
package org.imie.service.profil;

import java.util.List;

import javax.ejb.Local;

import model.Profil;

@Local
public interface ProfilServiceLocal
{
	public List<Profil> rechercherProfil(Profil profil);
	public Profil creerProfil(Profil profil);
	public Profil mettreAJourProfil(Profil profil);
	public void supprimerProfil(Profil profil);
}
