package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

import DAO.AdditifDao;
import DAO.AllergeneDao;
import DAO.CategorieDao;
import DAO.IngredientDao;
import DAO.MarqueDao;

public class IntegrationOpenFoodFacts {

	public void integrationOpenFoodFactsFile() {
		File file = new File("C:/SpringProject/traitement-fichier-jpa-off/csv/open-food-facts.csv");
		// int cmp = 0;

		try {
			List<String> lignes = FileUtils.readLines(file, "UTF-8");
			if (!lignes.isEmpty()) {
				lignes.remove(0);
				for (String ligne : lignes) {
					String[] decoupageLigne = ligne.split("\\|", -1);
					// System.out.println(decoupageLigne[28]);

					// Récup et Insertion d'un catégorie
					String nomCategorie = decoupageLigne[0].replaceAll("\"", "");
					CategorieDao catDao = new CategorieDao();
					catDao.insererCategorie(nomCategorie);

					// Récup et Insertion d'une marque
					String nomMarque = decoupageLigne[1];
					MarqueDao marDao = new MarqueDao();
					marDao.insererMarque(nomMarque);

					String nomProduit = decoupageLigne[2];

					String nutritionGrade = decoupageLigne[3];

					// Récupération de la liste d'ingrédient à partir du découpage
					List<String> ingredients = new ArrayList<String>(
							Arrays.asList(decoupageLigne[4].replaceAll("_", " ").split("[;,-]", -1)));
//					cmp++;
//					System.out.println(cmp);
					IngredientDao ingreDao = new IngredientDao();
					for (String ingredient : ingredients) {
						if (ingredient.length() <= 255) {
							// System.out.println(ingredient);
							ingreDao.insererIngredient(ingredient);
						}
					}

					double energie = DoubleUtils.parse(decoupageLigne[5]);

					double graisse = DoubleUtils.parse(decoupageLigne[6]);

					double sucre = DoubleUtils.parse(decoupageLigne[7]);

					double proteine = DoubleUtils.parse(decoupageLigne[9]);

					// Récupération de la liste d'ingrédient à partir du découpage
					List<String> allergenes = new ArrayList<String>(Arrays.asList(decoupageLigne[28].split(",", -1)));
					AllergeneDao allDao = new AllergeneDao();
					// System.out.println(allergenes);
					for (String allergene : allergenes) {
						allDao.insererAllergene(allergene);
					}

					// Récupération de la liste d'ingrédient à partir du découpage
					List<String> additifs = new ArrayList<String>(Arrays.asList(decoupageLigne[29].split(",", -1)));
					AdditifDao addiDao = new AdditifDao();
					// System.out.println(allergenes);
					for (String additif : additifs) {
						addiDao.insererAdditif(additif);
					}

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
