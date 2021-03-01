package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entites.Additif;
import entites.Produit;

public class AdditifDao extends AbstractDao {

	private EntityManager em;

	public AdditifDao(EntityManager em) {
		this.em = em;
	}

	public void insererAdditif(Produit produit, String name) {

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

		produit.getAdditifs().add(additifCree);
	}
}
