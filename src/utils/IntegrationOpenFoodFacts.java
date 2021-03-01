package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.commons.io.FileUtils;

import DAO.AbstractDao;
import DAO.AdditifDao;
import DAO.AllergeneDao;
import DAO.CategorieDao;
import DAO.IngredientDao;
import DAO.MarqueDao;
import DAO.ProduitDao;
import entites.Categorie;
import entites.Marque;
import entites.Produit;

public class IntegrationOpenFoodFacts extends AbstractDao {

	public void integrationOpenFoodFactsFile() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		int compteur = 0;

		File file = new File("C:/SpringProject/traitement-fichier-jpa-off/csv/open-food-facts.csv");

		// Création des DAO
		CategorieDao catDao = new CategorieDao(em);
		MarqueDao marDao = new MarqueDao(em);
		ProduitDao produitDao = new ProduitDao(em);
		IngredientDao ingreDao = new IngredientDao(em);
		AllergeneDao allDao = new AllergeneDao(em);
		AdditifDao addiDao = new AdditifDao(em);

		try {
			List<String> lignes = FileUtils.readLines(file, "UTF-8");
			if (!lignes.isEmpty()) {
				lignes.remove(0);

				for (String ligne : lignes) {

					transaction.begin();

					String[] decoupageLigne = ligne.split("\\|", -1);
					// System.out.println(decoupageLigne[28]);

					// Récup ou Insertion d'un catégorie
					Categorie categorieCree = catDao.insererCategorie(decoupageLigne);

					// Récup et Insertion d'une marque
					Marque marqueCree = marDao.insererMarque(decoupageLigne);

					// Insertion du Produit
					Produit produitCree = produitDao.insererProduit(decoupageLigne, categorieCree, marqueCree);

					// Récupération de la liste d'ingrédient à partir du découpage
					List<String> ingredients = new ArrayList<String>(Arrays.asList(decoupageLigne[4].trim()
							.replaceAll("[_.*)(?]", "").replaceAll("  ", " ").split("[;,-]", -1)));

					for (String ingredient : ingredients) {
						if (ingredient.length() <= 255) {
							ingreDao.insererIngredient(produitCree, ingredient);
						}
					}

					// Récupération de la liste d'ingrédient à partir du découpage
					List<String> allergenes = new ArrayList<String>(Arrays.asList(decoupageLigne[28].split(",", -1)));

					for (String allergene : allergenes) {
						allDao.insererAllergene(produitCree, allergene);
					}

					// Récupération de la liste d'ingrédient à partir du découpage
					List<String> additifs = new ArrayList<String>(Arrays.asList(decoupageLigne[29].split(",", -1)));

					for (String additif : additifs) {
						addiDao.insererAdditif(produitCree, additif);
					}

					compteur++;
					System.out.println(compteur);
					transaction.commit();
				}

			} else {
				System.out.println("Fichier vide sorry");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Problème à la lecture du fichier : " + e.getMessage());
		}

	}
}
