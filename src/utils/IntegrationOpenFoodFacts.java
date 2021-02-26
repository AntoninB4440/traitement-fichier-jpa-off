package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class IntegrationOpenFoodFacts {

	public void integrationOpenFoodFactsFile() {
		File file = new File("C:/SpringProject/traitement-fichier-jpa-off/csv/open-food-facts.csv");

		try {
			List<String> lignes = FileUtils.readLines(file, "UTF-8");
			lignes.remove(0);
			for (String ligne : lignes) {
				String[] decoupageLigne = ligne.split("\\|");
				for (String string : decoupageLigne) {
					System.out.println(string);
				}
				// System.out.println(decoupageLigne[28]);
				String categorie = decoupageLigne[0];
				String marque = decoupageLigne[1];
				String nomProduit = decoupageLigne[2];
				String nutritionGrade = decoupageLigne[3];

				// Récupération de la liste d'ingrédient à partir du découpage
				List<String> ingredients = new ArrayList<String>(
						Arrays.asList(decoupageLigne[4].replaceAll("_", "").split(",")));
				for (String ingredient : ingredients) {
					System.out.println(ingredient);
				}

				String energie = decoupageLigne[5];
				String graisse = decoupageLigne[6];
				String sucre = decoupageLigne[7];
				String protein = decoupageLigne[9];

				// Récupération de la liste d'ingrédient à partir du découpage
				List<String> allergenes = new ArrayList<String>(Arrays.asList(decoupageLigne[28].split(",")));
				// System.out.println(allergenes);
				for (String allergene : allergenes) {
					System.out.println(allergene);
				}

				// Récupération de la liste d'ingrédient à partir du découpage
				List<String> additifs = new ArrayList<String>(Arrays.asList(decoupageLigne[29].split(",")));
				// System.out.println(allergenes);
				for (String additif : additifs) {
					System.out.println(additifs);
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Problème à la lecture du fichier : " + e.getMessage());
		}

	}
}
