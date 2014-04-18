package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the droit database table.
 * 
 */
@Entity
@Table(name="droit")
public class Droit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="droit_id", unique=true, nullable=false)
	private Integer droitId;

	@Column(name="droit_intitule", nullable=false, length=25)
	private String droitIntitule;

	public Droit() {
	}

	public Integer getDroitId() {
		return this.droitId;
	}

	public void setDroitId(Integer droitId) {
		this.droitId = droitId;
	}

	public String getDroitIntitule() {
		return this.droitIntitule;
	}

	public void setDroitIntitule(String droitIntitule) {
		this.droitIntitule = droitIntitule;
	}

}