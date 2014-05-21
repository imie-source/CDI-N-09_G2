
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

	public Integer getProjId()
	{
		return this.id;
	}

	public void setProjId(Integer projId)
	{
		this.id = projId;
	}

	public String getProjAvancement()
	{
		return this.avancement;
	}

	public void setProjAvancement(String projAvancement)
	{
		this.avancement = projAvancement;
	}

	public Date getProjDatedebut()
	{
		return this.datedebut;
	}

	public void setProjDatedebut(Date projDatedebut)
	{
		this.datedebut = projDatedebut;
	}

	public Date getProjDatedefin()
	{
		return this.datedefin;
	}

	public void setProjDatedefin(Date projDatedefin)
	{
		this.datedefin = projDatedefin;
	}

	public String getProjDescription()
	{
		return this.description;
	}

	public void setProjDescription(String projDescription)
	{
		this.description = projDescription;
	}

	public String getProjNom()
	{
		return this.nom;
	}

	public void setProjNom(String projNom)
	{
		this.nom = projNom;
	}

	public String getProjWikiCdp()
	{
		return this.wikiCdp;
	}

	public void setProjWikiCdp(String projWikiCdp)
	{
		this.wikiCdp = projWikiCdp;
	}

	public String getProjWikiMembre()
	{
		return this.wikiMembre;
	}

	public void setProjWikiMembre(String projWikiMembre)
	{
		this.wikiMembre = projWikiMembre;
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