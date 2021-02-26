package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entites.Marque;

public class MarqueDao extends AbstractDao {

	private EntityManager em = emf.createEntityManager();

	public MarqueDao() {
	}

	public void insererMarque(String name) {
		TypedQuery<Marque> query = em.createQuery("Select m from Marque m WHERE m.nomMarque = :name ", Marque.class);
		query.setParameter("name", name);
		List<Marque> resultat = query.getResultList();
		if (resultat.isEmpty()) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();

			Marque marqueCree = new Marque(name);
			em.persist(marqueCree);

			transaction.commit();
		} else {
			System.out.println("La marque " + name + " existe déjà dans la BDD");
		}
	}
}
