
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
 * The persistent class for the projet database table.
 * 
 */

@Entity
@Table(name = "projet")
public class Projet implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proj_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "proj_avancement", length = 50)
	private String avancement;

	@Temporal(TemporalType.DATE)
	@Column(name = "proj_datedebut")
	private Date datedebut;

	@Temporal(TemporalType.DATE)
	@Column(name = "proj_datedefin")
	private Date datedefin;

	@Column(name = "proj_description", length = 1000)
	private String description;

	@Column(name = "proj_nom", nullable = false, length = 25)
	private String nom;

	@Column(name = "proj_wiki_cdp", length = 1000)
	private String wikiCdp;

	@Column(name = "proj_wiki_membre", length = 1000)
	private String wikiMembre;

	// uni-directional many-to-one association to Profil
	@ManyToOne
	@JoinColumn(name = "proj_prf_id")
	private Profil profil;

	public Projet()
	{
	}

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getAvancement()
	{
		return this.avancement;
	}

	public void setAvancement(String avancement)
	{
		this.avancement = avancement;
	}

	public Date getDatedebut()
	{
		return this.datedebut;
	}

	public void setDatedebut(Date datedebut)
	{
		this.datedebut = datedebut;
	}

	public Date getDatedefin()
	{
		return this.datedefin;
	}

	public void setDatedefin(Date datedefin)
	{
		this.datedefin = datedefin;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getNom()
	{
		return this.nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getWikiCdp()
	{
		return this.wikiCdp;
	}

	public void setWikiCdp(String wikiCdp)
	{
		this.wikiCdp = wikiCdp;
	}

	public String getWikiMembre()
	{
		return this.wikiMembre;
	}

	public void setWikiMembre(String wikiMembre)
	{
		this.wikiMembre = wikiMembre;
	}

	public Profil getProfil()
	{
		return this.profil;
	}

	public void setProfil(Profil profil)
	{
		this.profil = profil;
	}

}