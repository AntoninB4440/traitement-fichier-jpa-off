import utils.IntegrationOpenFoodFacts;

public class AppOff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Connection + creation base
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Off_JPA");
//		EntityManager em = entityManagerFactory.createEntityManager();

		IntegrationOpenFoodFacts integration = new IntegrationOpenFoodFacts();
		integration.integrationOpenFoodFactsFile();
	}

}
