
package model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the travaille database table.
 * 
 */

@Entity
@Table(name = "travaille")
public class Travaille implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TravaillePK id;

	public Travaille()
	{
	}

	public TravaillePK getId()
	{
		return this.id;
	}

	public void setId(TravaillePK id)
	{
		this.id = id;
	}

}