package entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "allergene")
public class Allergene {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "nom_allergene", nullable = false, length = 255, unique = true)
	private String nomAllergene;

	@ManyToMany(mappedBy = "allergenes")
	private List<Produit> produits;

	/**
	 * 
	 */
	public Allergene() {
		super();
	}

	/**
	 * @param nomAllergene
	 */
	public Allergene(String nomAllergene) {
		super();
		this.nomAllergene = nomAllergene;
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
	 * @return the nomAllergene
	 */
	public String getNomAllergene() {
		return nomAllergene;
	}

	/**
	 * @param nomAllergene the nomAllergene to set
	 */
	public void setNomAllergene(String nomAllergene) {
		this.nomAllergene = nomAllergene;
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
