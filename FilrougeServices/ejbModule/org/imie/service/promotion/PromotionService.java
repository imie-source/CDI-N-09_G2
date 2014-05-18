
package org.imie.service.promotion;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import model.Promotion;

/**
 * Session Bean implementation class PromotionService
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PromotionService implements PromotionServiceRemote,
		PromotionServiceLocal
{

	@PersistenceContext(unitName="FilrougeEntities")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public PromotionService()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Promotion> rechercherPromotion(Promotion promotion)
	{
		// Permet de fabriquer la requete morceau par morceau
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		// Contient les   predicates
		CriteriaQuery<Promotion> criteriaQuery = criteriaBuilder
				.createQuery(Promotion.class);
		
		// Entite concernée
		Root<Promotion> rootPromotion = criteriaQuery.from(Promotion.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		// Filtre sur id
		if (promotion.getPrmId() != null)
		{
			predicates.add(criteriaBuilder.equal(
					rootPromotion.<Integer> get("prmId"), promotion.getPrmId()));
		}
		
		// Filtre sur L'intitulé
		if (promotion.getPrmIntitule() != null)
		{
			predicates.add(criteriaBuilder.like(rootPromotion.<String> get("prmIntitule"),
					"%".concat(promotion.getPrmIntitule()).concat("%")));
		}
		
		// Filtre sur le lieu
		if (promotion.getPrmLieu() !=   null)
		{
			predicates.add(criteriaBuilder.like(rootPromotion.<String> get("prmLieu"),
					"%".concat(promotion.getPrmLieu()).concat("%")));
		}
		
		// Filtre sur la date de début
		if (promotion.getPrmDatedebut() != null)
		{
			predicates.add(criteriaBuilder.equal(rootPromotion.<String> get("prmDatedebut"),
					promotion.getPrmDatedebut()));
		}

		// Filtre sur la date de fin
		if (promotion.getPrmDatefin() != null)
		{
			predicates.add(criteriaBuilder.equal(rootPromotion.<String> get("prmDatefin"),
					promotion.getPrmDatefin()));
		}

		// Ajout des critères de recherche fabriqués ci-dessus
		criteriaQuery.where((Predicate[]) predicates
				.toArray(new Predicate[] {}));
		
		
		List<Promotion> result = entityManager.createQuery(criteriaQuery).getResultList();
		
		return result;
	}

	@Override
	public Promotion mettreAJourPromotion(Promotion promotionToUpdate)
	{
		// promotionToUpdate est un objet Promotion avec Id
		entityManager.merge(promotionToUpdate);
		return null;
	}

	@Override
	public Promotion creerPromotion(Promotion promotionToCreate)
	{
		// promotionToCreate est un objet Promotion sans Id
		entityManager.persist(promotionToCreate);
		return promotionToCreate;
	}

	@Override
	public void supprimerPromotion(Promotion promotion)
	{
		if (promotion.getPrmId() != null) 
		{
			entityManager.remove(entityManager.merge(promotion));
		}
	}

}
