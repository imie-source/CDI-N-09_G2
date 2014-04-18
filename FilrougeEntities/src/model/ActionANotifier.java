
package model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the action_a_notifier database table.
 * 
 */
@Entity
@Table(name = "action_a_notifier")
public class ActionANotifier implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_notif", unique = true, nullable = false)
	private Integer idNotif;

	@Column(name = "date_envoi", nullable = false)
	private Timestamp dateEnvoi;

	@Column(name = "notif_validee", nullable = false)
	private Boolean notifValidee;

	public ActionANotifier()
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

	public Timestamp getDateEnvoi()
	{
		return this.dateEnvoi;
	}

	public void setDateEnvoi(Timestamp dateEnvoi)
	{
		this.dateEnvoi = dateEnvoi;
	}

	public Boolean getNotifValidee()
	{
		return this.notifValidee;
	}

	public void setNotifValidee(Boolean notifValidee)
	{
		this.notifValidee = notifValidee;
	}

}