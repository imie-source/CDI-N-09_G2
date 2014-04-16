
/* 12 tables */

insert into droit (droit_intitule) values ('super_admin'), ('admin'), ('utilisateur');

insert into promotion (prm_intitule, prm_lieu, prm_datedebut, prm_datefin) values
	('CDI09', 'NANTES', '18/11/2013', '01/08/2014'),
	('DL08', 'NANTES', '03/09/2012', '26/04/2013'),
	('DL09', 'NANTES', '14/10/2013', '20/06/2014');

insert into profil (prf_nom, prf_prenom, prf_ident_connexion, prf_mdp_connexion,
	prf_email, prf_email_public, prf_disponibilite, prf_prm_id, prf_droit_id) values
	('super', 'admin', 'superAdmin', 'p@ssword', 'super.admin@imie.fr', false, false, null, 1),
	('admin', 'admin', 'unAdmin', 'p@ssword', 'admin.admin@imie.fr', false, false, null, 2),
	('user3', 'user', 'user3', 'p@ssword', 'user.user3@imie.fr', true, true, 3, 2),
	('user4', 'user', 'user4', 'p@ssword', 'user.user4@imie.fr', true, true, 1, 3),
	('user5', 'user', 'user5', 'p@ssword', 'user.user5@imie.fr', true, true, 2, 3),
	('user6', 'user', 'user6', 'p@ssword', 'user.user6@imie.fr', true, true, 3, 3),
	('user7', 'user', 'user7', 'p@ssword', 'user.user7@imie.fr', true, true, 2, 3),
	('user8', 'user', 'user8', 'p@ssword', 'user.user8@imie.fr', true, true, 1, 3);


insert into competence (comp_intitule, comp_valide, comp_id_1) values
	('informatique', true, null),
	('langage', true, 1),
	('C++', true, 2),
	('Java', true, 2),
	('Python', true, 2),
	('edi', true, 1),
	('Eclipse', true, 6),
	('Visual studio', true, 6),
	('comptabilité', true, null),
	('générale', true, 9),
	('analytique', true, 9),
	('Ruby', false, 2);

-- le profil prf_id possede la competance comp_id avec le niveau comp_niveau
insert into possede (comp_niveau, comp_id, prf_id) values
	(2, 7, 3),
	(4, 4, 3),
	(3, 5, 4),
	(4, 7, 4),
	(1, 10, 5),
	(5, 11, 6),
	(3, 8, 7),
	(3, 3, 7);

insert into projet (proj_nom, proj_prf_id) values
	('projet 1', null),
	('projet 2', 4),
	('projet 3', 5);

-- le profil prf_id travaille sur le projet proj_id (il peut en etre le chef de projet)
insert into travaille (prf_id,	proj_id) values
	(3, 2),
	(4, 2),
	(5, 2),
	(5, 3),
	(6, 3);

-- toutes les notifications sont datées et conservées
insert into action_a_notifier (date_envoi, notif_validee) values
	('10/03/2014 10:20', true),
	('10/03/2014 10:30', false),
	('11/03/2014 14:00', true),
	('12/03/2014 09:30', true),
	('12/03/2014 09:32', true),
	('13/03/2014 15:45', true),
	('13/03/2014 15:50', false);

-- le profil prf_id a envoyé la notification id_notif. c'est soit une proposition de compétence
-- soit une demande de faire partie d'un projet
insert into envoyer (id_notif, prf_id) values
	(3, 5),
	(6, 8),
	(7, 8);

insert into proposition_comp (id_notif,	comp_id)
	values (7, 12);

insert into candidature (id_notif, proj_id) values
	(3, 2),
	(6, 3);

-- le chef de projet du projet proj_id a envoyé au profil prf_id une invitation a
-- faire partie de son projet par la notification id_notif
insert into invitation_projet (id_notif, proj_id, prf_id) values
	(1, 2, 3),
	(2, 2, 7),
	(4, 3, 3),
	(5, 3, 6);


