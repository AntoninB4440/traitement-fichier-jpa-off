package entites;

/**
 * Classe enumération pour les NutritionGrade
 * 
 * @author anton
 *
 */
public enum NutritionGrade {

	A("a"), B("b"), C("c"), D("d"), E("e"), F("f");

	private String grade;

	/**
	 * @param grade
	 */
	NutritionGrade(String grade) {
		// TODO Auto-generated constructor stub
		this.grade = grade;
	}

	/**
	 * Methode pour retrouver l'instance NutritionGarde en fonction du nom passé
	 * 
	 * @param grade
	 * @return
	 */
	public static NutritionGrade find(String grade) {
		NutritionGrade[] listgrades = NutritionGrade.values();
		for (NutritionGrade listgrade : listgrades) {
			if (listgrade.getGrade().equals(grade)) {
				return listgrade;
			}
		}
		return null;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
