package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entites.Ingredient;

/**
 * Classe gérant le CRUD d'un ingrédient
 * 
 * @author anton
 *
 */
public class IngredientDao extends AbstractDao {

	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public IngredientDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Méthode afin d'insérer sans doublon en BDD un ingrédient à l'aide de son nom
	 * 
	 * @param name
	 * @return un object Ingredient
	 */
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
