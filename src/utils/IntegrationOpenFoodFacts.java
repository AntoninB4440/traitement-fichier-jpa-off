package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

import DAO.CategorieDao;
import DAO.MarqueDao;

public class IntegrationOpenFoodFacts {

	public void integrationOpenFoodFactsFile() {
		File file = new File("C:/SpringProject/traitement-fichier-jpa-off/csv/open-food-facts.csv");

		try {
			List<String> lignes = FileUtils.readLines(file, "UTF-8");
			lignes.remove(0);
			for (String ligne : lignes) {
				String[] decoupageLigne = ligne.split("\\|", -1);
				// System.out.println(decoupageLigne[28]);

				// Récup et Insertion d'un catégorie
				String nomCategorie = decoupageLigne[0];
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
						Arrays.asList(decoupageLigne[4].replaceAll("_", "").split(",", -1)));
//				for (String ingredient : ingredients) {
//					System.out.println(ingredient);
//				}

				double energie = DoubleUtils.parse(decoupageLigne[5]);

				double graisse = DoubleUtils.parse(decoupageLigne[6]);

				double sucre = DoubleUtils.parse(decoupageLigne[7]);

				double proteine = DoubleUtils.parse(decoupageLigne[9]);

				// Récupération de la liste d'ingrédient à partir du découpage
				List<String> allergenes = new ArrayList<String>(Arrays.asList(decoupageLigne[28].split(",", -1)));
				// System.out.println(allergenes);
//				for (String allergene : allergenes) {
//					System.out.println(allergene);
//				}

				// Récupération de la liste d'ingrédient à partir du découpage
				List<String> additifs = new ArrayList<String>(Arrays.asList(decoupageLigne[29].split(",", -1)));
				// System.out.println(allergenes);
//				for (String additif : additifs) {
//					System.out.println(additif);
//				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Problème à la lecture du fichier : " + e.getMessage());
		}

	}
}
