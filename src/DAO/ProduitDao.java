package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entites.Additif;
import entites.Allergene;
import entites.Categorie;
import entites.Ingredient;
import entites.Marque;
import entites.NutritionGrade;
import entites.Produit;
import utils.DoubleUtils;

/**
 * Classe gérant le CRUD d'un produit
 * 
 * @author anton
 *
 */
public class ProduitDao extends AbstractDao {

	private EntityManager em;

	/**
	 * Construteur
	 * 
	 * @param em
	 */
	public ProduitDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Méthode afin d'insérer sans doublon en BDD un produit à l'aide de son nom de
	 * sa catégorie et de sa marque, set également les informations relatif à se
	 * produit comme, l'energie100g, graisse100g etc etc
	 * 
	 * @param decoupageLigne
	 * @param categorie
	 * @param marque
	 * @return
	 */
	public Produit insererProduit(String[] decoupageLigne, Categorie categorie, Marque marque) {

		String nomProduit = decoupageLigne[2];

		double energie = DoubleUtils.parse(decoupageLigne[5]);

		double graisse = DoubleUtils.parse(decoupageLigne[6]);

		double sucre = DoubleUtils.parse(decoupageLigne[7]);

		double proteine = DoubleUtils.parse(decoupageLigne[9]);

		String nutritionGrade = decoupageLigne[3];

		Produit produitCree = null;

		TypedQuery<Produit> query = em.createQuery(
				"Select p from Produit p JOIN p.categorie c JOIN p.marque m WHERE p.nomProduit = ?1 AND c.nomCategorie = ?2 AND m.nomMarque = ?3",
				Produit.class);
		query.setParameter(1, nomProduit);
		query.setParameter(2, categorie.getNomCategorie());
		query.setParameter(3, marque.getNomMarque());

		List<Produit> resultat = query.getResultList();
		if (resultat.isEmpty()) {

			produitCree = new Produit(nomProduit, categorie, marque);
			produitCree.setEnergie100gProduit(energie);
			produitCree.setGraisse100gProduit(graisse);
			produitCree.setSucre100gProduit(sucre);
			produitCree.setProteine100gProduit(proteine);
			produitCree.setNutritionGradeFrProduit(NutritionGrade.find(nutritionGrade));
			em.persist(produitCree);

		} else {
			produitCree = resultat.get(0);
		}
		return produitCree;
	}

	/**
	 * Permet de set une liste d'ingrédient à un produit
	 * 
	 * @param listeIngredients
	 * @param produit
	 */
	public void ajouterIngredientsProduit(List<Ingredient> listeIngredients, Produit produit) {
		produit.setIngredients(listeIngredients);
	}

	/**
	 * Permet de set une liste d'allergene à un produit
	 * 
	 * @param listeIngredients
	 * @param produit
	 */
	public void ajouterAllergenesProduit(List<Allergene> listeAllergenes, Produit produit) {
		produit.setAllergenes(listeAllergenes);
	}

	/**
	 * Permet de set une liste d'additif à un produit
	 * 
	 * @param listeIngredients
	 * @param produit
	 */
	public void ajouterAdditifsProduit(List<Additif> listeAdditifs, Produit produit) {
		produit.setAdditifs(listeAdditifs);
	}
}
