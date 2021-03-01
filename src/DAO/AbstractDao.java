package DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe abstraite afin de partager la même base de connection entre les
 * classes de l'application
 * 
 * @author anton
 */
public class AbstractDao {

	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Off_JPA");
}
