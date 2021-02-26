import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppOff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Connection + creation base
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Off_JPA");
		EntityManager em = entityManagerFactory.createEntityManager();
	}

}
