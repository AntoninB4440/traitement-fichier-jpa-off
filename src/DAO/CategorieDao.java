package DAO;

import javax.persistence.EntityManager;

public class CategorieDao extends AbstractDao {

	private EntityManager em = emf.createEntityManager();

	public CategorieDao() {
	}
}
