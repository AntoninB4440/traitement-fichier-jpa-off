package utils;

/**
 * Classe utilitaire pour l'entite Ingredient
 * 
 * @author anton
 *
 */
public class IngredientUtils {

	/**
	 * Formate un String et le convertie en tableau de string via un split
	 * 
	 * @param tableau
	 * @return
	 */
	public static String[] formatted(String tableau) {
		String trimedString = tableau.trim();
		String replacedString = trimedString.replaceAll("[\\[\\]_.)(?*]", "").replaceAll("  ", " ").toLowerCase();
		String[] splitedString = replacedString.split("[;,-]", -1);

		return splitedString;

	}
}
