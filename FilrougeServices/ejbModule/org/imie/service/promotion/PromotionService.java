
package org.imie.service.promotion;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Promotion;

/**
 * Session Bean implementation class PromotionService
 */
@Stateless
@LocalBean
public class PromotionService implements PromotionServiceRemote,
		PromotionServiceLocal
{

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public PromotionService()
	{
		// TODO Auto-generated constructor stub
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
