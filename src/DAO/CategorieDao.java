package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entites.Categorie;

public class CategorieDao extends AbstractDao {

	private EntityManager em = emf.createEntityManager();

	private EntityTransaction transaction = em.getTransaction();

	public CategorieDao() {
	}

	public void insererCategorie(String name) {
		TypedQuery<Categorie> query = em.createQuery("Select c from Categorie c WHERE c.nomCategorie = :name ",
				Categorie.class);
		query.setParameter("name", name);
		List<Categorie> resultat = query.getResultList();
		if (resultat.isEmpty()) {

			transaction.begin();

			Categorie categorieCree = new Categorie(name);
			em.persist(categorieCree);

			transaction.commit();
		} else {
			System.out.println("La catégorie " + name + " existe déjà dans la BDD");
		}
	}
}
