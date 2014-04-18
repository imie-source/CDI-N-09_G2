package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the travaille database table.
 * 
 */
@Embeddable
public class TravaillePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="prf_id", unique=true, nullable=false)
	private Integer prfId;

	@Column(name="proj_id", unique=true, nullable=false)
	private Integer projId;

	public TravaillePK() {
	}
	public Integer getPrfId() {
		return this.prfId;
	}
	public void setPrfId(Integer prfId) {
		this.prfId = prfId;
	}
	public Integer getProjId() {
		return this.projId;
	}
	public void setProjId(Integer projId) {
		this.projId = projId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TravaillePK)) {
			return false;
		}
		TravaillePK castOther = (TravaillePK)other;
		return 
			this.prfId.equals(castOther.prfId)
			&& this.projId.equals(castOther.projId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.prfId.hashCode();
		hash = hash * prime + this.projId.hashCode();
		
		return hash;
	}
}