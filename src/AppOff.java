import utils.IntegrationOpenFoodFacts;

/**
 * @author anton Classe permettant de lancer l'application (voir pour rajouter
 *         des menus en fonction des DAO )
 */
public class AppOff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IntegrationOpenFoodFacts integration = new IntegrationOpenFoodFacts();
		integration.integrationOpenFoodFactsFile();
	}

}
