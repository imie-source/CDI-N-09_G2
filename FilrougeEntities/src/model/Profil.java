package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the profil database table.
 * 
 */
@Entity
@Table(name="profil")
public class Profil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prf_id", unique=true, nullable=false)
	private Integer prfId;

	@Temporal(TemporalType.DATE)
	@Column(name="prf_date_naissance")
	private Date prfDateNaissance;

	@Column(name="prf_disponibilite", nullable=false)
	private Boolean prfDisponibilite;

	@Column(name="prf_email", nullable=false, length=50)
	private String prfEmail;

	@Column(name="prf_email_public", nullable=false)
	private Boolean prfEmailPublic;

	@Column(name="prf_ident_connexion", nullable=false, length=25)
	private String prfIdentConnexion;

	@Column(name="prf_infos", length=50)
	private String prfInfos;

	@Column(name="prf_mdp_connexion", nullable=false, length=25)
	private String prfMdpConnexion;

	@Column(name="prf_nom", nullable=false, length=50)
	private String prfNom;

	@Column(name="prf_prenom", nullable=false, length=50)
	private String prfPrenom;

	//uni-directional many-to-one association to Droit
	@ManyToOne
	@JoinColumn(name="prf_droit_id", nullable=false)
	private Droit droit;

	//uni-directional many-to-one association to Promotion
	@ManyToOne
	@JoinColumn(name="prf_prm_id")
	private Promotion promotion;

	public Profil() {
	}

	public Integer getPrfId() {
		return this.prfId;
	}

	public void setPrfId(Integer prfId) {
		this.prfId = prfId;
	}

	public Date getPrfDateNaissance() {
		return this.prfDateNaissance;
	}

	public void setPrfDateNaissance(Date prfDateNaissance) {
		this.prfDateNaissance = prfDateNaissance;
	}

	public Boolean getPrfDisponibilite() {
		return this.prfDisponibilite;
	}

	public void setPrfDisponibilite(Boolean prfDisponibilite) {
		this.prfDisponibilite = prfDisponibilite;
	}

	public String getPrfEmail() {
		return this.prfEmail;
	}

	public void setPrfEmail(String prfEmail) {
		this.prfEmail = prfEmail;
	}

	public Boolean getPrfEmailPublic() {
		return this.prfEmailPublic;
	}

	public void setPrfEmailPublic(Boolean prfEmailPublic) {
		this.prfEmailPublic = prfEmailPublic;
	}

	public String getPrfIdentConnexion() {
		return this.prfIdentConnexion;
	}

	public void setPrfIdentConnexion(String prfIdentConnexion) {
		this.prfIdentConnexion = prfIdentConnexion;
	}

	public String getPrfInfos() {
		return this.prfInfos;
	}

	public void setPrfInfos(String prfInfos) {
		this.prfInfos = prfInfos;
	}

	public String getPrfMdpConnexion() {
		return this.prfMdpConnexion;
	}

	public void setPrfMdpConnexion(String prfMdpConnexion) {
		this.prfMdpConnexion = prfMdpConnexion;
	}

	public String getPrfNom() {
		return this.prfNom;
	}

	public void setPrfNom(String prfNom) {
		this.prfNom = prfNom;
	}

	public String getPrfPrenom() {
		return this.prfPrenom;
	}

	public void setPrfPrenom(String prfPrenom) {
		this.prfPrenom = prfPrenom;
	}

	public Droit getDroit() {
		return this.droit;
	}

	public void setDroit(Droit droit) {
		this.droit = droit;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

}