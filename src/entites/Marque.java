package entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "marque")
public class Marque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "nom_marque", nullable = false, length = 255, unique = true)
	private String nomMarque;

	@Column(name = "id_produit")
	@OneToMany(mappedBy = "marque")
	private List<Produit> produits;

	/**
	 * 
	 */
	public Marque() {
		super();
	}

	/**
	 * @param nomCategorie
	 */
	public Marque(String nomMarque) {
		super();
		this.nomMarque = nomMarque;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nomCategorie
	 */
	public String getNomMarque() {
		return nomMarque;
	}

	/**
	 * @param nomCategorie the nomCategorie to set
	 */
	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	/**
	 * @return the produits
	 */
	public List<Produit> getProduits() {
		return produits;
	}

	/**
	 * @param produits the produits to set
	 */
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
