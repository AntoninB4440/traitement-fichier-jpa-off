package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entites.Additif;

public class AdditifDao extends AbstractDao {

	private EntityManager em = emf.createEntityManager();

	private EntityTransaction transaction = em.getTransaction();

	public AdditifDao() {
	}

	public void insererAdditif(String name) {
		TypedQuery<Additif> query = em.createQuery("Select a from Additif a WHERE a.nomAdditif = :name ",
				Additif.class);
		query.setParameter("name", name);
		List<Additif> resultat = query.getResultList();
		if (resultat.isEmpty()) {

			transaction.begin();

			Additif additifCree = new Additif(name);
			em.persist(additifCree);

			transaction.commit();

		} else {
			System.out.println("L'additif" + name + " existe déjà dans la BDD");
		}
	}
}
