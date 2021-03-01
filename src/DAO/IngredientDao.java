package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entites.Ingredient;

public class IngredientDao extends AbstractDao {

	private EntityManager em = emf.createEntityManager();

	private EntityTransaction transaction = em.getTransaction();

	public IngredientDao() {
	}

	public void insererIngredient(String name) {
		TypedQuery<Ingredient> query = em.createQuery("Select i from Ingredient i WHERE i.nomIngredient = :name ",
				Ingredient.class);
		query.setParameter("name", name);
		List<Ingredient> resultat = query.getResultList();
		if (resultat.isEmpty()) {

			transaction.begin();

			Ingredient ingredientCree = new Ingredient(name);
			em.persist(ingredientCree);

			transaction.commit();
		} else {
			System.out.println("L'ingredient " + name + " existe déjà dans la BDD");
		}
	}
}
