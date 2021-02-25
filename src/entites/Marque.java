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
	private String nomCategorie;

	@Column(name = "id_produit")
	@OneToMany(mappedBy = "marque")
	private List<Produit> produits;

}
