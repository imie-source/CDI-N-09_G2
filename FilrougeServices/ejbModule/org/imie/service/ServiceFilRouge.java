
package org.imie.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Stack;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Competence;
import model.Profil;
import model.Promotion;

/**
 * Session Bean implementation class ServiceFilRouge
 */
@Stateless
@LocalBean
public class ServiceFilRouge implements ServiceFilRougeRemote,
		ServiceFilRougeLocal
{

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ServiceFilRouge()
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

	@Override
	public List<Promotion> lookForClass(Promotion promotion)
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		String queryString = new String("SELECT p FROM Promotion p");
		String condition = new String("");
		if (promotion.getPrmId() != null)
		{
			condition = concatConditionString(condition,
					"p.prmId=" + String.valueOf(promotion.getPrmId()));
		}
		if (promotion.getPrmIntitule() != null)
		{
			condition = concatConditionString(condition,
					"p.prmIntitule like '%".concat(promotion.getPrmIntitule())
							.concat("%'"));
		}
		if (promotion.getPrmDatedebut() != null)
		{
			condition = concatConditionString(
					condition,
					"p.prmDatedebut='".concat(simpleDateFormat.format(
							promotion.getPrmDatedebut()).concat("'")));
			// ci-dessous on passe d'une date java.util a une date java.sql ; ce
			// qui n'est pas utile pour nous
			// nous nous traduisons une Date en String
			// statement.setDate(compteurCondition++, new
			// Date(personne.getDateNaiss().getTime()));
		}
		if (promotion.getPrmDatefin() != null)
		{
			condition = concatConditionString(
					condition,
					"p.prmDatefin='".concat(simpleDateFormat.format(
							promotion.getPrmDatefin()).concat("'")));
		}
		if (promotion.getPrmLieu() != null)
		{
			condition = concatConditionString(condition, "p.prmLieu like '%"
					.concat(promotion.getPrmLieu()).concat("%'"));
		}
		System.out.println("lookForClass " + queryString + condition);
		Query query = entityManager.createQuery(queryString.concat(condition));
		@SuppressWarnings("unchecked")
		List<Promotion> result = (List<Promotion>) query.getResultList();
		return result;
	}

	@Override
	public Promotion updateClass(Promotion promotionToUpdate)
	{
		// TODO Auto-generated method stub
		// promotionToUpdate est un objet Promotion avec Id
		entityManager.merge(promotionToUpdate);
		return null;
	}

	@Override
	public Promotion createClass(Promotion promotionToCreate)
	{
		// TODO Auto-generated method stub
		// promotionToCreate est un objet Promotion sans Id
		entityManager.persist(promotionToCreate);
		return promotionToCreate;
	}

	private String concatConditionString(String buildString, String condition)
	{
		buildString = buildString.concat(
				buildString.length() > 0 ? " and " : " where ").concat(
				condition);
		return buildString;
	}

}
