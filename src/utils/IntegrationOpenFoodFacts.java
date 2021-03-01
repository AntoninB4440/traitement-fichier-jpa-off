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
import entites.Additif;
import entites.Allergene;
import entites.Categorie;
import entites.Ingredient;
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
					List<String> ingredients = new ArrayList<String>(
							Arrays.asList(IngredientFormated.formatted(decoupageLigne[4])));
					List<Ingredient> listIngredients = new ArrayList<>();

					for (String ingredient : ingredients) {
						if (ingredient.length() <= 255) {
							Ingredient ingredientCree = ingreDao.insererIngredient(ingredient);
							listIngredients.add(ingredientCree);
						}
					}
					produitDao.ajouterIngredientsProduit(listIngredients, produitCree);

					// Récupération de la liste d'ingrédient à partir du découpage
					List<String> allergenes = new ArrayList<String>(Arrays.asList(decoupageLigne[28].split(",", -1)));
					List<Allergene> listAllergenes = new ArrayList<>();

					for (String allergene : allergenes) {
						Allergene allergeneCree = allDao.insererAllergene(allergene);
						listAllergenes.add(allergeneCree);
					}
					produitDao.ajouterAllergenesProduit(listAllergenes, produitCree);

					// Récupération de la liste d'ingrédient à partir du découpage
					List<String> additifs = new ArrayList<String>(Arrays.asList(decoupageLigne[29].split(",", -1)));
					List<Additif> listAdditifs = new ArrayList<>();

					for (String additif : additifs) {
						Additif additifCree = addiDao.insererAdditif(additif);
						listAdditifs.add(additifCree);
					}
					produitDao.ajouterAdditifsProduit(listAdditifs, produitCree);

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
