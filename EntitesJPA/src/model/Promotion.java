
package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Promotion
 * 
 */
@Entity
public class Promotion implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prm_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "prm_intitule", length = 50)
	private String intitule;

	@Column(name = "prm_lieu", length = 25)
	private String lieu;

	@Temporal(TemporalType.DATE)
	@Column(name = "prm_datedebut")
	private Date dateDebut;

	@Temporal(TemporalType.DATE)
	@Column(name = "prm_datefin")
	private Date dateFin;

	public Promotion()
	{
		super();
	}

}
