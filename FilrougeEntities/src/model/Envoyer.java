
package model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the envoyer database table.
 * 
 */
@Entity
@Table(name = "envoyer")
public class Envoyer implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EnvoyerPK id;

	public Envoyer()
	{
	}

	public EnvoyerPK getId()
	{
		return this.id;
	}

	public void setId(EnvoyerPK id)
	{
		this.id = id;
	}

}