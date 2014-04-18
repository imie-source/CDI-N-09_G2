
package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the possede database table.
 * 
 */
@Embeddable
public class PossedePK implements Serializable
{
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "comp_id", unique = true, nullable = false)
	private Integer compId;

	@Column(name = "prf_id", unique = true, nullable = false)
	private Integer prfId;

	public PossedePK()
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

	public Integer getPrfId()
	{
		return this.prfId;
	}

	public void setPrfId(Integer prfId)
	{
		this.prfId = prfId;
	}

	public boolean equals(Object other)
	{
		if (this == other)
		{
			return true;
		}
		if (!(other instanceof PossedePK))
		{
			return false;
		}
		PossedePK castOther = (PossedePK) other;
		return this.compId.equals(castOther.compId)
				&& this.prfId.equals(castOther.prfId);
	}

	public int hashCode()
	{
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compId.hashCode();
		hash = hash * prime + this.prfId.hashCode();

		return hash;
	}
}