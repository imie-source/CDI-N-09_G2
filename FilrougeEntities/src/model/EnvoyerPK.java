
package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the envoyer database table.
 * 
 */
@Embeddable
public class EnvoyerPK implements Serializable
{
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "id_notif", unique = true, nullable = false)
	private Integer idNotif;

	@Column(name = "prf_id", unique = true, nullable = false)
	private Integer prfId;

	public EnvoyerPK()
	{
	}

	public Integer getIdNotif()
	{
		return this.idNotif;
	}

	public void setIdNotif(Integer idNotif)
	{
		this.idNotif = idNotif;
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
		if (!(other instanceof EnvoyerPK))
		{
			return false;
		}
		EnvoyerPK castOther = (EnvoyerPK) other;
		return this.idNotif.equals(castOther.idNotif)
				&& this.prfId.equals(castOther.prfId);
	}

	public int hashCode()
	{
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idNotif.hashCode();
		hash = hash * prime + this.prfId.hashCode();

		return hash;
	}
}