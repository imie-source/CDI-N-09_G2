
package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the competence database table.
 * 
 */
@Entity
@Table(name = "competence")
public class Competence implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comp_id", unique = true, nullable = false)
	private Integer compId;

	@Column(name = "comp_intitule", nullable = false, length = 50)
	private String compIntitule;

	@Column(name = "comp_valide", nullable = false)
	private Boolean compValide;

	// bi-directional many-to-one association to Competence
	@ManyToOne
	@JoinColumn(name = "comp_id_1")
	private Competence competence;

	// bi-directional many-to-one association to Competence
	@OneToMany(mappedBy = "competence")
	private List<Competence> competences;

	public Competence()
	{
	}

	public Integer getCompId()
	{
		return this.compId;
	}

	public void setCompId(Integer compId)
	{
		this.compId = compId;
	}

	public String getCompIntitule()
	{
		return this.compIntitule;
	}

	public void setCompIntitule(String compIntitule)
	{
		this.compIntitule = compIntitule;
	}

	public Boolean getCompValide()
	{
		return this.compValide;
	}

	public void setCompValide(Boolean compValide)
	{
		this.compValide = compValide;
	}

	public Competence getCompetence()
	{
		return this.competence;
	}

	public void setCompetence(Competence competence)
	{
		this.competence = competence;
	}

	public List<Competence> getCompetences()
	{
		return this.competences;
	}

	public void setCompetences(List<Competence> competences)
	{
		this.competences = competences;
	}

	public Competence addCompetence(Competence competence)
	{
		getCompetences().add(competence);
		competence.setCompetence(this);

		return competence;
	}

	public Competence removeCompetence(Competence competence)
	{
		getCompetences().remove(competence);
		competence.setCompetence(null);

		return competence;
	}

}