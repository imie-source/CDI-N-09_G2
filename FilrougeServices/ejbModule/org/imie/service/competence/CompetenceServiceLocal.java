
package org.imie.service.competence;

import java.util.List;

import javax.ejb.Local;

import model.Competence;

@Local
public interface CompetenceServiceLocal
{
	public List<Competence> rechercherCompetence(Competence competence);
	public Competence creerCompetence(Competence competence);
	public Competence mettreAJourCompetence(Competence competence);
	public void supprimerCompetence(Competence competence);
	public List<Competence> skillsTree(Boolean validated);
//	public void test();
}
