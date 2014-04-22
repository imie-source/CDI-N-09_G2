
package org.imie.service.profil;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import model.Profil;

/**
 * Session Bean implementation class ProfilService
 */
@Stateless
@LocalBean
public class ProfilService implements ProfilServiceRemote, ProfilServiceLocal
{

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ProfilService()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Profil> rechercherProfil(Profil profil)
	{
		// Permet de fabriquer la requete morceau par morceau
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		// Contient les predicates
		CriteriaQuery<Profil> criteriaQuery = criteriaBuilder
				.createQuery(Profil.class);

		// Entite concernée
		Root<Profil> rootProfil = criteriaQuery.from(Profil.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		// Filtre sur id
		if (profil.getId() != null)
		{
			predicates.add(criteriaBuilder.equal(
					rootProfil.<Integer> get("id"), profil.getId()));
		}

		// Filtre sur prenom
		if (profil.getPrenom() != null)
		{
			predicates.add(criteriaBuilder.like(
					rootProfil.<String> get("prenom"),
					"%".concat(profil.getPrenom()).concat("%")));
		}

		// Filtre sur nom
		if (profil.getNom() != null)
		{
			predicates.add(criteriaBuilder.like(rootProfil.<String> get("nom"),
					"%".concat(profil.getPrenom()).concat("%")));
		}

		// Filtre sur date de naissance
		if (profil.getDateNaissance() != null)
		{
			predicates.add(criteriaBuilder.equal(
					rootProfil.<String> get("dateNaissance"),
					profil.getDateNaissance()));
		}

		// Ajout des criteres de recherche fabriques ci dessus
		criteriaQuery.where((Predicate[]) predicates
				.toArray(new Predicate[] {}));

		// Execution de la requete
		List<Profil> result = entityManager.createQuery(criteriaQuery)
				.getResultList();

		return result;
	}

	@Override
	public void supprimerProfil(Profil profil)
	{
		if (profil.getId() != null)
		{
			entityManager.remove(profil);
		}

	}

	@Override
	public Profil mettreAJour(Profil profil)
	{
		Profil result = new Profil();
		if (profil.getId() != null)
		{
			result = entityManager.merge(profil);
		}
		return result;
	}

}
