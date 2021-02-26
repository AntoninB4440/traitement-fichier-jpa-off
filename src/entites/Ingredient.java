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
@Table(name = "ingredient")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "nom_ingredient", nullable = false, length = 255, unique = true)
	private String nomIngredient;

	@ManyToMany(mappedBy = "ingredients")
	private List<Produit> produits;

	/**
	 * 
	 */
	public Ingredient() {
		super();
	}

	/**
	 * @param nomIngredient
	 */
	public Ingredient(String nomIngredient) {
		super();
		this.nomIngredient = nomIngredient;
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
	 * @return the nomIngredient
	 */
	public String getNomIngredient() {
		return nomIngredient;
	}

	/**
	 * @param nomIngredient the nomIngredient to set
	 */
	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
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
