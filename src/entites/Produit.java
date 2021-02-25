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

	@Column(name = "sucres100g_Produit")
	private Double sucres100gProduit;

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

}
