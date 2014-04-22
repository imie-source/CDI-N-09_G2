
package org.imie.service.profil;

import java.util.List;

import javax.ejb.Local;

import model.Profil;

@Local
public interface ProfilServiceLocal
{

	List<Profil> rechercherProfil(Profil profil);

	void supprimerProfil(Profil profil);

	Profil mettreAJour(Profil profil);
}
