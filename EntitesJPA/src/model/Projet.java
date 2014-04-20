
package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Projet
 * 
 */
@Entity(name = "projet")
public class Projet implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1624589602637107971L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proj_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "proj_nom", nullable = false, length = 25)
	private String Nom;

	@Column(name = "proj_datedebut", nullable = true)
	private Date dateDebut;

	@Column(name = "proj_datedefin", nullable = true)
	private Date dateFin;

	@Column(name = "proj_description", nullable = true, length = 1000)
	private String description;

	@Column(name = "proj_wiki_cdp", nullable = false, length = 1000)
	private String wikiP;

	@Column(name = "proj_wiki_membre", nullable = false, length = 1000)
	private String wikiM;

	@Column(name = "proj_avancement", nullable = false, length = 50)
	private String avancement;

	public Projet()
	{
		super();
	}

}
