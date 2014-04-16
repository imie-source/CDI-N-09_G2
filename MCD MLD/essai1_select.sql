select prf_nom, prf_disponibilite, prm_intitule, droit_intitule
	from profil
	left join promotion on promotion.prm_id = profil.prf_prm_id
	inner join droit on droit.droit_id = profil.prf_droit_id
	order by prf_nom;


-- Liste de tous les utilisateurs (meme ceux qui n'ont pas de competence) avec leurs compétences et le niveau
select prf_nom, comp_intitule, comp_niveau from profil
	left join possede on possede.prf_id = profil.prf_id
	left join competence on competence.comp_id = possede.comp_id;

-- liste des utilisateurs avec les projets sur lesquels il travaille et s'il est le chef de projet
select prf_nom, proj_nom, (projet.proj_prf_id = profil.prf_id) chef_de_projet from profil
	inner join travaille on travaille.prf_id = profil.prf_id
	inner join projet on projet.proj_id = travaille.proj_id;

-- liste des utilisateurs selon les invitations qu'ils ont reçu, à faire partie d'un projet
select prf_nom, proj_nom, date_envoi from profil
	inner join invitation_projet on invitation_projet.prf_id = profil.prf_id
	inner join projet on projet.proj_id = invitation_projet.proj_id
	inner join action_a_notifier on action_a_notifier.id_notif = invitation_projet.id_notif
	where not action_a_notifier.notif_validee;

-- liste des compétences à valider
select comp_intitule, prf_nom, date_envoi from competence
	inner join proposition_comp on proposition_comp.comp_id = competence.comp_id
	inner join envoyer on envoyer.id_notif = proposition_comp.id_notif
	inner join profil on profil.prf_id = envoyer.prf_id
	inner join action_a_notifier on action_a_notifier.id_notif = envoyer.id_notif
	where not comp_valide and not notif_validee; -- bizarre ce double not

-- pour chaque projet (donc chef de projet) liste des candidatures reçues pour ce projet
select proj_nom, p1.prf_nom chef_projet, p2.prf_nom envoyeur from projet
	inner join profil p1 on p1.prf_id = projet.proj_prf_id
	inner join candidature on candidature.proj_id = projet.proj_id
	inner join envoyer on envoyer.id_notif = candidature.id_notif
	inner join profil p2 on p2.prf_id = envoyer.prf_id;

-- pour chaque utilisateur liste des invitations à participer à un projet reçu
select prf_nom, proj_nom, date_envoi from profil
	inner join invitation_projet on invitation_projet.prf_id = profil.prf_id
	inner join projet on projet.proj_id = invitation_projet.proj_id
	inner join action_a_notifier on action_a_notifier.id_notif = invitation_projet.id_notif
	where not notif_validee;


