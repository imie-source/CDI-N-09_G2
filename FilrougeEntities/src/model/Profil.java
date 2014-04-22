
package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the profil database table.
 * 
 */
@Entity
@Table(name = "profil")
public class Profil implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prf_id", unique = true, nullable = false)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "prf_date_naissance")
	private Date dateNaissance;

	@Column(name = "prf_disponibilite", nullable = false)
	private Boolean disponibilite;

	@Column(name = "prf_email", nullable = false, length = 50)
	private String email;

	@Column(name = "prf_email_public", nullable = false)
	private Boolean emailPublic;

	@Column(name = "prf_ident_connexion", nullable = false, length = 25)
	private String identConnexion;

	@Column(name = "prf_infos", length = 50)
	private String infos;

	@Column(name = "prf_mdp_connexion", nullable = false, length = 25)
	private String mdpConnexion;

	@Column(name = "prf_nom", nullable = false, length = 50)
	private String nom;

	@Column(name = "prf_prenom", nullable = false, length = 50)
	private String prenom;

	// uni-directional many-to-one association to Droit
	@ManyToOne
	@JoinColumn(name = "prf_droit_id", nullable = false)
	private Droit droit;

	// uni-directional many-to-one association to Promotion
	@ManyToOne
	@JoinColumn(name = "prf_prm_id")
	private Promotion promotion;

	public Profil()
	{
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Date getDateNaissance()
	{
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance)
	{
		this.dateNaissance = dateNaissance;
	}

	public Boolean getDisponibilite()
	{
		return disponibilite;
	}

	public void setDisponibilite(Boolean disponibilite)
	{
		this.disponibilite = disponibilite;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Boolean getEmailPublic()
	{
		return emailPublic;
	}

	public void setEmailPublic(Boolean emailPublic)
	{
		this.emailPublic = emailPublic;
	}

	public String getIdentConnexion()
	{
		return identConnexion;
	}

	public void setIdentConnexion(String identConnexion)
	{
		this.identConnexion = identConnexion;
	}

	public String getInfos()
	{
		return infos;
	}

	public void setInfos(String infos)
	{
		this.infos = infos;
	}

	public String getMdpConnexion()
	{
		return mdpConnexion;
	}

	public void setMdpConnexion(String mdpConnexion)
	{
		this.mdpConnexion = mdpConnexion;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public Droit getDroit()
	{
		return droit;
	}

	public void setDroit(Droit droit)
	{
		this.droit = droit;
	}

	public Promotion getPromotion()
	{
		return promotion;
	}

	public void setPromotion(Promotion promotion)
	{
		this.promotion = promotion;
	}

}