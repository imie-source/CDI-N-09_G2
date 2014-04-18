
package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the proposition_comp database table.
 * 
 */
@Entity
@Table(name = "proposition_comp")
public class PropositionComp implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_notif", unique = true, nullable = false)
	private Integer idNotif;

	// uni-directional one-to-one association to ActionANotifier
	@OneToOne
	@JoinColumn(name = "id_notif", nullable = false, insertable = false, updatable = false)
	private ActionANotifier actionANotifier;

	// uni-directional many-to-one association to Competence
	@ManyToOne
	@JoinColumn(name = "comp_id", nullable = false)
	private Competence competence;

	public PropositionComp()
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

	public ActionANotifier getActionANotifier()
	{
		return this.actionANotifier;
	}

	public void setActionANotifier(ActionANotifier actionANotifier)
	{
		this.actionANotifier = actionANotifier;
	}

	public Competence getCompetence()
	{
		return this.competence;
	}

	public void setCompetence(Competence competence)
	{
		this.competence = competence;
	}

}