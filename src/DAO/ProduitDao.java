package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entites.Categorie;
import entites.Marque;
import entites.NutritionGrade;
import entites.Produit;
import utils.DoubleUtils;

public class ProduitDao extends AbstractDao {

	private EntityManager em;

	public ProduitDao(EntityManager em) {
		this.em = em;
	}

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
}
