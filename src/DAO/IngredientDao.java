package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entites.Ingredient;

public class IngredientDao extends AbstractDao {

	private EntityManager em;

	public IngredientDao(EntityManager em) {
		this.em = em;
	}

	public Ingredient insererIngredient(String name) {

		if (!name.isEmpty()) {

			Ingredient ingredientCree = null;

			TypedQuery<Ingredient> query = em.createQuery("Select i from Ingredient i WHERE i.nomIngredient = :name ",
					Ingredient.class);

			query.setParameter("name", name);

			List<Ingredient> resultat = query.getResultList();

			if (resultat.isEmpty()) {

				ingredientCree = new Ingredient(name);
				em.persist(ingredientCree);

			} else {
				ingredientCree = resultat.get(0);
			}

			return ingredientCree;
		}
		return null;

	}
}
