package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entites.Allergene;

public class AllergeneDao extends AbstractDao {

	private EntityManager em = emf.createEntityManager();

	private EntityTransaction transaction = em.getTransaction();

	public AllergeneDao() {
	}

	public void insererAllergene(String name) {
		TypedQuery<Allergene> query = em.createQuery("Select a from Allergene a WHERE a.nomAllergene = :name ",
				Allergene.class);
		query.setParameter("name", name);
		List<Allergene> resultat = query.getResultList();
		if (resultat.isEmpty()) {

			transaction.begin();

			Allergene allergeneCree = new Allergene(name);
			em.persist(allergeneCree);

			transaction.commit();

		} else {
			System.out.println("L'allergene" + name + " existe déjà dans la BDD");
		}
	}
}
