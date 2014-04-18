
package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Profil
 * 
 */
@Entity
@Table(name = "profil")
public class Profil implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3752839960214853188L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "prf_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "prf_nom", nullable = false, length = 50)
	private String nom;

	@Column(name = "prf_prenom", nullable = false, length = 50)
	private String prenom;

	@Column(name = "prf_ident_connexion", nullable = false, length = 25)
	private String identifiant;

	@Column(name = "prf_mdp_connexion", nullable = false, length = 25)
	private String motDePasse;

	@Temporal(TemporalType.DATE)
	@Column(name = "prf_date_naissance")
	private Date dateNaissance;

	@Column(name = "prf_infos", length = 50)
	private String infos;

	@Column(name = "prf_email", nullable = false, length = 50)
	private String email;

	@Column(name = "prf_email_public")
	private Boolean emailPublic;

	@Column(name = "prf_disponibilite")
	private Boolean disponibilite;

	// @ManyToOne(fetch=FetchType.LAZY)
	@ManyToMany
	@JoinTable(name = "EMP_PROJ", joinColumns = { @JoinColumn(name = "EMP_ID", referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "PROJ_ID", referencedColumnName = "ID") })
	private Promotion promotion;

	@Enumerated(EnumType.ORDINAL)
	@ManyToOne
	@JoinColumn(name = "droit_id")
	private Droit droit;

	public Profil()
	{
		super();
	}

}
