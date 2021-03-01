package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entites.Additif;

/**
 * Classe gérant le CRUD d'un additif
 * 
 * @author anton
 */
public class AdditifDao extends AbstractDao {

	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public AdditifDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Méthode afin d'insérer sans doublon en BDD un additif à l'aide de son nom
	 * 
	 * @param name étant le nom de l'additif
	 * @return un object Additif
	 */
	public Additif insererAdditif(String name) {

		Additif additifCree = null;

		TypedQuery<Additif> query = em.createQuery("Select a from Additif a WHERE a.nomAdditif = :name ",
				Additif.class);

		query.setParameter("name", name);

		List<Additif> resultat = query.getResultList();

		if (resultat.isEmpty()) {

			additifCree = new Additif(name);
			em.persist(additifCree);

		} else {
			additifCree = resultat.get(0);
		}

		return additifCree;
	}
}
