
package org.imie.service.projet;

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

import model.Profil;
import model.Projet;

/**
 * Session Bean implementation class ProjetService
 */
@Stateless(name = "ProjetService")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProjetService implements ProjetServiceRemote, ProjetServiceLocal
{

	@PersistenceContext(unitName = "FilrougeEntities")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ProjetService()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Projet> rechercherProjet(Projet projet)
	{
		// Permet de fabriquer la requete morceau par morceau
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		// Contient les predicates
		CriteriaQuery<Projet> criteriaQuery = criteriaBuilder
				.createQuery(Projet.class);

		// Entite concernée
		Root<Projet> rootProjet = criteriaQuery.from(Projet.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		// Filtre sur id
		if (projet.getId() != null)
		{
			predicates.add(criteriaBuilder.equal(
					rootProjet.<Integer> get("id"), projet.getId()));
		}

		// Filtre sur nom
		if (projet.getNom() != null)
		{
			predicates.add(criteriaBuilder.like(rootProjet.<String> get("nom"),
					"%".concat(projet.getNom()).concat("%")));
		}

		// Filtre sur Avancement
		if (projet.getAvancement() != null)
		{
			predicates.add(criteriaBuilder.equal(
					rootProjet.<String> get("prenom"), projet.getAvancement()));
		}

		// Filtre sur Profil
		if (projet.getProfil() != null)
		{
			predicates.add(criteriaBuilder.equal(
					rootProjet.<Profil> get("profil"), projet.getProfil()));
		}

		// Ajout des criteres de recherche fabriques ci dessus
		criteriaQuery.where((Predicate[]) predicates
				.toArray(new Predicate[] {}));

		// Execution de la requete
		List<Projet> result = entityManager.createQuery(criteriaQuery)
				.getResultList();

		return result;
	}

	@Override
	public Projet creerProjet(Projet projet)
	{
		entityManager.persist(projet);
		return projet;
	}

	@Override
	public Projet mettreAJourProjet(Projet projet)
	{
		Projet result = null;
		if (projet.getId() != null)
		{
			result = entityManager.merge(projet);
		}
		return result;
	}

	@Override
	public void supprimerProjet(Projet projet)
	{
		if (projet.getId() != null)
		{
			entityManager.remove(entityManager.merge(projet));
		}
	}

}
