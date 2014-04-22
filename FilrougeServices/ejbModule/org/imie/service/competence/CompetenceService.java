
package org.imie.service.competence;

import java.util.List;
import java.util.Stack;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Competence;
import model.Profil;

/**
 * Session Bean implementation class ServiceFilRouge
 */
@Stateless
@LocalBean
public class CompetenceService implements CompetenceServiceRemote,
		CompetenceServiceLocal
{

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CompetenceService()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void test()
	{
		// int id = 1;
		// Profil profil = entityManager.find(Profil.class, id);
		// if (profil == null) {
		// System.out.println("Le profil " + id + "n'existe pas");
		// } else {
		// System.out.format("%d %s %s%n", profil.getPrfId(),
		// profil.getPrfNom(), profil.getPrfPrenom());
		// }
		Query query = entityManager.createQuery("select p from Profil p"); // OK
		@SuppressWarnings("unchecked")
		List<Profil> result = (List<Profil>) query.getResultList();
		for (Profil profil : result)
		{
			System.out.format("%d %s %s (%d %s)", profil.getPrfId(), profil
					.getPrfNom(), profil.getPrfPrenom(), profil.getDroit()
					.getDroitId(), profil.getDroit().getDroitIntitule());
			if (profil.getPromotion() == null)
			{
				System.out.format(" ce profil n'a pas de promotion%n");

			}
			else
			{
				System.out.format(" (%d %s %s)%n", profil.getPromotion()
						.getPrmId(), profil.getPromotion().getPrmIntitule(),
						profil.getPromotion().getPrmLieu());
			}

		}
	}

	private void parcourtRecursif(List<Competence> enfants)
	{
		if (enfants == null)
			return; // arret du parcourt recursif

		for (Competence competence : enfants)
		{
			System.out.print(" " + competence.getCompIntitule());
			parcourtRecursif(competence.getCompetences());
		}
	}

	private void parcourtIteratif(List<Competence> racine)
	{
		System.out.println("parcourtIteratif");
		Stack<Competence> stack = new Stack<Competence>();
		// initialisation de la pile
		for (Competence competence : racine)
		{
			stack.push(competence);
		}

		while (!stack.empty())
		{
			Competence noeud = stack.pop();
			System.out.println(" " + noeud.getCompIntitule());
			if (noeud.getCompetences() != null)
			{
				for (Competence competence : noeud.getCompetences())
				{
					stack.push(competence);
				}
			}
		}
	}

	@Override
	public List<Competence> skillsTree(Boolean validated)
	{
		Query query = entityManager
				.createQuery("SELECT c FROM Competence c WHERE c.competence IS Null");
		@SuppressWarnings("unchecked")
		List<Competence> result = (List<Competence>) query.getResultList();
		System.out.println("skillsTree [" + result + "]");

		parcourtRecursif(result);
		System.out.println();
		parcourtIteratif(result);
		System.out.println();

		// if (result != null) {
		// for (Competence competence: result) {
		// System.out.format("%d %s %s parent:%s enfant:%s%n"
		// , competence.getCompId(), competence.getCompIntitule()
		// , competence.getCompValide()
		// , competence.getCompetence() == null ? "null" :
		// competence.getCompetence().getCompIntitule()
		// , competence.getCompetences() == null ? "null" :
		// competence.getCompetences().get(0).getCompIntitule()
		// );
		// }
		// }
		return result;
	}

}
