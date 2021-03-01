package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entites.Categorie;

public class CategorieDao extends AbstractDao {

	private EntityManager em;

	public CategorieDao(EntityManager em) {
		this.em = em;
	}

	public Categorie insererCategorie(String[] decoupageLigne) {

		String nomCategorie = decoupageLigne[0].replaceAll("\"", "");

		Categorie categorieCree = null;

		TypedQuery<Categorie> query = em.createQuery("Select c from Categorie c WHERE c.nomCategorie = :name ",
				Categorie.class);
		query.setParameter("name", nomCategorie);

		List<Categorie> resultat = query.getResultList();

		if (resultat.isEmpty()) {

			categorieCree = new Categorie(nomCategorie);
			em.persist(categorieCree);

		} else {
			categorieCree = resultat.get(0);
		}
		return categorieCree;

	}
}
