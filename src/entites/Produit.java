package entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

}
