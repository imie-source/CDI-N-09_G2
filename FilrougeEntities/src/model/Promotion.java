
package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the promotion database table.
 * 
 */

@Entity
@Table(name = "promotion")
public class Promotion implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prm_id", unique = true, nullable = false)
	private Integer prmId;

	@Temporal(TemporalType.DATE)
	@Column(name = "prm_datedebut", nullable = false)
	private Date prmDatedebut;

	@Temporal(TemporalType.DATE)
	@Column(name = "prm_datefin", nullable = false)
	private Date prmDatefin;

	@Column(name = "prm_intitule", nullable = false, length = 50)
	private String prmIntitule;

	@Column(name = "prm_lieu", nullable = false, length = 25)
	private String prmLieu;

	public Promotion()
	{
	}

	public Integer getPrmId()
	{
		return this.prmId;
	}

	public void setPrmId(Integer prmId)
	{
		this.prmId = prmId;
	}

	public Date getPrmDatedebut()
	{
		return this.prmDatedebut;
	}

	public void setPrmDatedebut(Date prmDatedebut)
	{
		this.prmDatedebut = prmDatedebut;
	}

	public Date getPrmDatefin()
	{
		return this.prmDatefin;
	}

	public void setPrmDatefin(Date prmDatefin)
	{
		this.prmDatefin = prmDatefin;
	}

	public String getPrmIntitule()
	{
		return this.prmIntitule;
	}

	public void setPrmIntitule(String prmIntitule)
	{
		this.prmIntitule = prmIntitule;
	}

	public String getPrmLieu()
	{
		return this.prmLieu;
	}

	public void setPrmLieu(String prmLieu)
	{
		this.prmLieu = prmLieu;
	}

}