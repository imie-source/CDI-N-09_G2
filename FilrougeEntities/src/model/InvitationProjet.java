package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the invitation_projet database table.
 * 
 */
@Entity
@Table(name="invitation_projet")
public class InvitationProjet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_notif", unique=true, nullable=false)
	private Integer idNotif;

	//uni-directional one-to-one association to ActionANotifier
	@OneToOne
	@JoinColumn(name="id_notif", nullable=false, insertable=false, updatable=false)
	private ActionANotifier actionANotifier;

	//uni-directional many-to-one association to Profil
	@ManyToOne
	@JoinColumn(name="prf_id", nullable=false)
	private Profil profil;

	//uni-directional many-to-one association to Projet
	@ManyToOne
	@JoinColumn(name="proj_id", nullable=false)
	private Projet projet;

	public InvitationProjet() {
	}

	public Integer getIdNotif() {
		return this.idNotif;
	}

	public void setIdNotif(Integer idNotif) {
		this.idNotif = idNotif;
	}

	public ActionANotifier getActionANotifier() {
		return this.actionANotifier;
	}

	public void setActionANotifier(ActionANotifier actionANotifier) {
		this.actionANotifier = actionANotifier;
	}

	public Profil getProfil() {
		return this.profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

}