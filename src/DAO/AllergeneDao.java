package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entites.Allergene;

/**
 * Classe gérant le CRUD d'un allergene
 * 
 * @author anton
 *
 */
public class AllergeneDao extends AbstractDao {

	private EntityManager em;

	/**
	 * Construteur
	 * 
	 * @param em
	 */
	public AllergeneDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Méthode afin d'insérer sans doublon en BDD un allergene à l'aide de son nom
	 * 
	 *
	 * @param name
	 * @return un object Allergene
	 */
	public Allergene insererAllergene(String name) {

		Allergene allergeneCree = null;

		TypedQuery<Allergene> query = em.createQuery("Select a from Allergene a WHERE a.nomAllergene = :name ",
				Allergene.class);

		query.setParameter("name", name);

		List<Allergene> resultat = query.getResultList();

		if (resultat.isEmpty()) {

			allergeneCree = new Allergene(name);
			em.persist(allergeneCree);

		} else {
			allergeneCree = resultat.get(0);
		}

		return allergeneCree;
	}
}
