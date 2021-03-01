package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entites.Allergene;

public class AllergeneDao extends AbstractDao {

	private EntityManager em;

	public AllergeneDao(EntityManager em) {
		this.em = em;
	}

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
