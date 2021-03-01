package utils;

/**
 * Classe utilitaire de Double parsing
 * 
 * @author anton
 *
 */
public class DoubleUtils {

	/**
	 * Parse un string en double en fonction de si le string est vide ou non
	 * 
	 * @param valeur
	 * @return
	 */
	public static Double parse(String valeur) {
		if (valeur.isEmpty()) {
			return 0.0;
		} else {
			return Double.parseDouble(valeur);
		}
	}
}
