
package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Competence
 * 
 */
@Entity
@Table(name = "Competence")
public class Competence implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7792523593065767385L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comp_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "comp_intitule", nullable = false, length = 50)
	private String intitule;

	@Column(name = "comp_valide", nullable = false)
	private Boolean valide;

	@OneToMany
	@JoinColumn(name = "comp_id_1", referencedColumnName = "comp_id")
	private List<Competence> sousComp;

	public Competence()
	{
		super();
	}

}
