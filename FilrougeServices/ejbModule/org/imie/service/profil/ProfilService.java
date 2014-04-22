
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

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Profil> criteriaQuery = criteriaBuilder
				.createQuery(Profil.class);

		Root<Profil> rootProfil = criteriaQuery.from(Profil.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		// if()

		return null;
	}

	@Override
	public void supprimerProfil(Profil profil)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Profil mettreAJour(Profil profil)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
