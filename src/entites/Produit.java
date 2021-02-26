package entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "nom_produit", nullable = false, length = 255)
	private String nomProduit;

	@Column(name = "nutritionGradeFr_Produit", length = 1)
	private NutritionGrade nutritionGradeFrProduit;

	@Column(name = "energie100g_Produit")
	private Double energie100gProduit;

	@Column(name = "graisse100g_Produit")
	private Double graisse100gProduit;

	@Column(name = "sucre100g_Produit")
	private Double sucre100gProduit;

	@Column(name = "proteine100g_Produit")
	private Double proteine100gProduit;

	@ManyToOne
	@JoinColumn(name = "id_categorie")
	private Categorie categorie;

	@ManyToOne
	@JoinColumn(name = "id_marque")
	private Marque marque;

	@ManyToMany
	@JoinTable(name = "ingredient_produit", joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "id_ingredient", referencedColumnName = "ID"))
	private List<Ingredient> ingredients;

	@ManyToMany
	@JoinTable(name = "allergene_produit", joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "id_allergene", referencedColumnName = "ID"))
	private List<Allergene> allergenes;

	@ManyToMany
	@JoinTable(name = "additif_produit", joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "id_additif", referencedColumnName = "ID"))
	private List<Additif> additifs;

	/**
	 * 
	 */
	public Produit() {
		super();
	}

	// On garde les attributs qui permettent d'identifier de manière unique un
	// produit
	/**
	 * 
	 * @param nomProduit
	 * @param categorie
	 * @param marque
	 */
	public Produit(String nomProduit, Categorie categorie, Marque marque) {
		super();
		this.nomProduit = nomProduit;
		this.categorie = categorie;
		this.marque = marque;
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
	 * @return the nomProduit
	 */
	public String getNomProduit() {
		return nomProduit;
	}

	/**
	 * @param nomProduit the nomProduit to set
	 */
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	/**
	 * @return the nutritionGradeFrProduit
	 */
	public NutritionGrade getNutritionGradeFrProduit() {
		return nutritionGradeFrProduit;
	}

	/**
	 * @param nutritionGradeFrProduit the nutritionGradeFrProduit to set
	 */
	public void setNutritionGradeFrProduit(NutritionGrade nutritionGradeFrProduit) {
		this.nutritionGradeFrProduit = nutritionGradeFrProduit;
	}

	/**
	 * @return the energie100gProduit
	 */
	public Double getEnergie100gProduit() {
		return energie100gProduit;
	}

	/**
	 * @param energie100gProduit the energie100gProduit to set
	 */
	public void setEnergie100gProduit(Double energie100gProduit) {
		this.energie100gProduit = energie100gProduit;
	}

	/**
	 * @return the graisse100gProduit
	 */
	public Double getGraisse100gProduit() {
		return graisse100gProduit;
	}

	/**
	 * @param graisse100gProduit the graisse100gProduit to set
	 */
	public void setGraisse100gProduit(Double graisse100gProduit) {
		this.graisse100gProduit = graisse100gProduit;
	}

	/**
	 * @return the sucre100gProduit
	 */
	public Double getSucre100gProduit() {
		return sucre100gProduit;
	}

	/**
	 * @param sucre100gProduit the sucre100gProduit to set
	 */
	public void setSucre100gProduit(Double sucre100gProduit) {
		this.sucre100gProduit = sucre100gProduit;
	}

	/**
	 * @return the proteine100gProduit
	 */
	public Double getProteine100gProduit() {
		return proteine100gProduit;
	}

	/**
	 * @param proteine100gProduit the proteine100gProduit to set
	 */
	public void setProteine100gProduit(Double proteine100gProduit) {
		this.proteine100gProduit = proteine100gProduit;
	}

	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}

	/**
	 * @param marque the marque to set
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	/**
	 * @return the ingredients
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the allergenes
	 */
	public List<Allergene> getAllergenes() {
		return allergenes;
	}

	/**
	 * @param allergenes the allergenes to set
	 */
	public void setAllergenes(List<Allergene> allergenes) {
		this.allergenes = allergenes;
	}

	/**
	 * @return the additifs
	 */
	public List<Additif> getAdditifs() {
		return additifs;
	}

	/**
	 * @param additifs the additifs to set
	 */
	public void setAdditifs(List<Additif> additifs) {
		this.additifs = additifs;
	}

}
