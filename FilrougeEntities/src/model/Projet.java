
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
	private Integer projId;

	@Column(name = "proj_avancement", length = 50)
	private String projAvancement;

	@Temporal(TemporalType.DATE)
	@Column(name = "proj_datedebut")
	private Date projDatedebut;

	@Temporal(TemporalType.DATE)
	@Column(name = "proj_datedefin")
	private Date projDatedefin;

	@Column(name = "proj_description", length = 1000)
	private String projDescription;

	@Column(name = "proj_nom", nullable = false, length = 25)
	private String projNom;

	@Column(name = "proj_wiki_cdp", length = 1000)
	private String projWikiCdp;

	@Column(name = "proj_wiki_membre", length = 1000)
	private String projWikiMembre;

	// uni-directional many-to-one association to Profil
	@ManyToOne
	@JoinColumn(name = "proj_prf_id")
	private Profil profil;

	public Projet()
	{
	}

	public Integer getProjId()
	{
		return this.projId;
	}

	public void setProjId(Integer projId)
	{
		this.projId = projId;
	}

	public String getProjAvancement()
	{
		return this.projAvancement;
	}

	public void setProjAvancement(String projAvancement)
	{
		this.projAvancement = projAvancement;
	}

	public Date getProjDatedebut()
	{
		return this.projDatedebut;
	}

	public void setProjDatedebut(Date projDatedebut)
	{
		this.projDatedebut = projDatedebut;
	}

	public Date getProjDatedefin()
	{
		return this.projDatedefin;
	}

	public void setProjDatedefin(Date projDatedefin)
	{
		this.projDatedefin = projDatedefin;
	}

	public String getProjDescription()
	{
		return this.projDescription;
	}

	public void setProjDescription(String projDescription)
	{
		this.projDescription = projDescription;
	}

	public String getProjNom()
	{
		return this.projNom;
	}

	public void setProjNom(String projNom)
	{
		this.projNom = projNom;
	}

	public String getProjWikiCdp()
	{
		return this.projWikiCdp;
	}

	public void setProjWikiCdp(String projWikiCdp)
	{
		this.projWikiCdp = projWikiCdp;
	}

	public String getProjWikiMembre()
	{
		return this.projWikiMembre;
	}

	public void setProjWikiMembre(String projWikiMembre)
	{
		this.projWikiMembre = projWikiMembre;
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