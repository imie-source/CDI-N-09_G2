
package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Droit
 * 
 */
@Entity
@Table(name = "droit")
public class Droit implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2849769808683088879L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "droit_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "droit_intitule", nullable = false, length = 25)
	private String intitule;

	public Droit()
	{
		super();
	}

}
