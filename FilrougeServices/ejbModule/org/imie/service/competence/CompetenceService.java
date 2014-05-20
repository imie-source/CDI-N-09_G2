
package org.imie.service.competence;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import model.Competence;

/**
 * Session Bean implementation class ServiceFilRouge
 */
@Stateless(name = "CompetenceService")
@TransactionManagement(TransactionManagementType.CONTAINER)
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
	public List<Competence> rechercherCompetence(Competence competence)
	{
		// Permet de fabriquer la requete morceau par morceau
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		// Contient les predicates
		CriteriaQuery<Competence> criteriaQuery = criteriaBuilder
				.createQuery(Competence.class);

		// Entite concernée
		Root<Competence> rootCompetence = criteriaQuery.from(Competence.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		// Filtre sur l'id
		if (competence.getCompId() != null)
		{
			predicates
					.add(criteriaBuilder.equal(
							rootCompetence.<Integer> get("id"),
							competence.getCompId()));
		}
		// Filtre sur l'intitulé
		if (competence.getCompIntitule() != null)
		{
			predicates.add(criteriaBuilder.like(
					rootCompetence.<String> get("comp_intitule"),
					competence.getCompIntitule()));
		}
		// Filtre sur la validité
		if (competence.getCompValide() != null)
		{
			predicates.add(criteriaBuilder.equal(
					rootCompetence.<Boolean> get("comp_valide"),
					competence.getCompValide()));
		}

		// Ajout des critères de recherche fabriqués si dessus
		criteriaQuery.where((Predicate[]) predicates
				.toArray(new Predicate[] {}));

		// Execution de la requete
		List<Competence> result = entityManager.createQuery(criteriaQuery)
				.getResultList();

		return result;
	}

	@Override
	public Competence creerCompetence(Competence competence)
	{
		entityManager.persist(competence);
		return competence;
	}

	@Override
	public Competence mettreAJourCompetence(Competence competence)
	{
		Competence result = new Competence();
		if (competence.getCompId() != null)
		{
			result = entityManager.merge(competence);
		}
		return result;

	}

	@Override
	public void supprimerCompetence(Competence competence)
	{
		if (competence.getCompId() != null)
		{
			entityManager.remove(entityManager.merge(competence));
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

	// @Override
	// public void test()
	// {
	// // int id = 1;
	// // Profil profil = entityManager.find(Profil.class, id);
	// // if (profil == null) {
	// // System.out.println("Le profil " + id + "n'existe pas");
	// // } else {
	// // System.out.format("%d %s %s%n", profil.getPrfId(),
	// // profil.getPrfNom(), profil.getPrfPrenom());
	// // }
	// Query query = entityManager.createQuery("select p from Profil p"); // OK
	// @SuppressWarnings("unchecked")
	// List<Profil> result = (List<Profil>) query.getResultList();
	// for (Profil profil : result)
	// {
	// System.out.format("%d %s %s (%d %s)", profil.getId(), profil
	// .getNom(), profil.getPrenom(), profil.getDroit()
	// .getDroitId(), profil.getDroit().getDroitIntitule());
	// if (profil.getPromotion() == null)
	// {
	// System.out.format(" ce profil n'a pas de promotion%n");
	//
	// }
	// else
	// {
	// System.out.format(" (%d %s %s)%n", profil.getPromotion()
	// .getPrmId(), profil.getPromotion().getPrmIntitule(),
	// profil.getPromotion().getPrmLieu());
	// }
	//
	// }
	// }

}
