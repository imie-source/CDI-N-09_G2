
package org.imie.service.droit;

import java.util.ArrayList;
import java.util.List;

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

import model.Droit;

/**
 * Session Bean implementation class DroitService
 */
@Stateless(name = "DroitService")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DroitService implements DroitServiceRemote, DroitServiceLocal
{

	@PersistenceContext(unitName = "FilrougeEntities")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public DroitService()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Droit> rechercherDroit(Droit droit)
	{
		// Permet de fabriquer la requete morceau par morceau
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		// Contient les predicates
		CriteriaQuery<Droit> criteriaQuery = criteriaBuilder
				.createQuery(Droit.class);

		// Entite concernée
		Root<Droit> rootdroit = criteriaQuery.from(Droit.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		// Filtre sur id
		if (droit.getDroitId() != null)
		{
			predicates.add(criteriaBuilder.equal(rootdroit.<Integer> get("id"),
					droit.getDroitId()));
		}

		// Filtre sur nom
		if (droit.getDroitIntitule() != null)
		{
			predicates.add(criteriaBuilder.like(rootdroit.<String> get("nom"),
					"%".concat(droit.getDroitIntitule()).concat("%")));
		}

		// Ajout des criteres de recherche fabriques ci dessus
		criteriaQuery.where((Predicate[]) predicates
				.toArray(new Predicate[] {}));

		// Execution de la requete
		List<Droit> result = entityManager.createQuery(criteriaQuery)
				.getResultList();

		return result;
	}

	@Override
	public Droit creerDroit(Droit droit)
	{
		entityManager.persist(droit);
		return droit;
	}

	@Override
	public Droit mettreAJourDroit(Droit droit)
	{
		if (droit.getDroitId() != null)
		{
			entityManager.merge(droit);
		}
		return droit;
	}

	@Override
	public void supprimerDroit(Droit droit)
	{
		if (droit.getDroitId() != null)
		{
			entityManager.remove(entityManager.merge(droit));
		}
	}

}
