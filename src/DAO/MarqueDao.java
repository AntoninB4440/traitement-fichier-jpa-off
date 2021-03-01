package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entites.Marque;

public class MarqueDao extends AbstractDao {

	private EntityManager em;

	public MarqueDao(EntityManager em) {
		this.em = em;
	}

	public Marque insererMarque(String[] decoupageLigne) {

		String nomMarque = decoupageLigne[1];

		Marque marqueCree = null;

		TypedQuery<Marque> query = em.createQuery("Select m from Marque m WHERE m.nomMarque = :name ", Marque.class);

		query.setParameter("name", nomMarque);

		List<Marque> resultat = query.getResultList();

		if (resultat.isEmpty()) {

			marqueCree = new Marque(nomMarque);
			em.persist(marqueCree);

		} else {
			marqueCree = resultat.get(0);
		}

		return marqueCree;
	}

}
