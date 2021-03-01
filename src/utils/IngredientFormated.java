package utils;

public class IngredientFormated {

	public static String[] formatted(String tableau) {
		String trimedString = tableau.trim();
		String replacedString = trimedString.replaceAll("[\\[\\]_.)(?*]", "").replaceAll("  ", " ").toLowerCase();
		String[] splitedString = replacedString.split("[;,-]", -1);

		return splitedString;

	}
}
