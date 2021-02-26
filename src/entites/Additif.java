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
@Table(name = "additif")
public class Additif {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "nom_additif", nullable = false, length = 255, unique = true)
	private String nomAdditif;

	@ManyToMany(mappedBy = "additifs")
	private List<Produit> produits;

	/**
	 * 
	 */
	public Additif() {
		super();
	}

	/**
	 * @param nomAdditif
	 */
	public Additif(String nomAdditif) {
		super();
		this.nomAdditif = nomAdditif;
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
	 * @return the nomAdditif
	 */
	public String getNomAdditif() {
		return nomAdditif;
	}

	/**
	 * @param nomAdditif the nomAdditif to set
	 */
	public void setNomAdditif(String nomAdditif) {
		this.nomAdditif = nomAdditif;
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
