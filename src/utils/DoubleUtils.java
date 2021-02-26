package utils;

public class DoubleUtils {

	public static Double parse(String valeur) {
		if (valeur.isEmpty()) {
			return 0.0;
		} else {
			return Double.parseDouble(valeur);
		}
	}
}
