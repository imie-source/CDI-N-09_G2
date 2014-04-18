
package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the possede database table.
 * 
 */
@Entity
@Table(name = "possede")
public class Possede implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PossedePK id;

	@Column(name = "comp_niveau", nullable = false)
	private Integer compNiveau;

	// uni-directional many-to-one association to Competence
	@ManyToOne
	@JoinColumn(name = "comp_id", nullable = false, insertable = false, updatable = false)
	private Competence competence;

	// uni-directional many-to-one association to Profil
	@ManyToOne
	@JoinColumn(name = "prf_id", nullable = false, insertable = false, updatable = false)
	private Profil profil;

	public Possede()
	{
	}

	public PossedePK getId()
	{
		return this.id;
	}

	public void setId(PossedePK id)
	{
		this.id = id;
	}

	public Integer getCompNiveau()
	{
		return this.compNiveau;
	}

	public void setCompNiveau(Integer compNiveau)
	{
		this.compNiveau = compNiveau;
	}

	public Competence getCompetence()
	{
		return this.competence;
	}

	public void setCompetence(Competence competence)
	{
		this.competence = competence;
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