package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entites.Categorie;
import entites.Marque;
import entites.Produit;

public class ProduitDao extends AbstractDao {

	private EntityManager em = emf.createEntityManager();

	private EntityTransaction transaction = em.getTransaction();

	public ProduitDao() {
	}

	public void insererProduit(String nomProduit, Categorie categorie, Marque marque) {
		TypedQuery<Produit> query = em.createQuery(
				"Select p from Produit p JOIN Categorie c JOIN Marque m WHERE p.nomProduit = ?1 AND c.nomCategorie = ?2 AND m.nomMarque = ?3",
				Produit.class);
		query.setParameter(1, nomProduit);
		query.setParameter(2, categorie.getNomCategorie());
		query.setParameter(3, marque.getNomMarque());

		List<Produit> resultat = query.getResultList();
		if (resultat.isEmpty()) {

			transaction.begin();
			Produit produitCree = new Produit(nomProduit, categorie, marque);
			em.persist(produitCree);

			transaction.commit();
		} else {
			System.out.println("La produit " + nomProduit + " existe déjà dans la BDD");
		}
	}
}
