
package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Competence
 * 
 */
@Entity
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

	public Competence()
	{
		super();
	}

}
