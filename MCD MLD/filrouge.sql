------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------


CREATE TABLE public.profil(
	prf_id              SERIAL NOT NULL ,
	prf_nom             VARCHAR (50) NOT NULL ,
	prf_prenom          VARCHAR (50) NOT NULL ,
	prf_ident_connexion VARCHAR (25) NOT NULL ,
	prf_mdp_connexion   VARCHAR (25) NOT NULL ,
	prf_date_naissance  DATE   ,
	prf_infos           VARCHAR (50)  ,
	prf_email           VARCHAR (50) NOT NULL ,
	prf_email_public    BOOL  NOT NULL ,
	prf_disponibilite   BOOL  NOT NULL ,
	prm_id              INT  NOT NULL ,
	droit_id            INT  NOT NULL ,
	CONSTRAINT prk_constraint_profil PRIMARY KEY (prf_id)
)WITHOUT OIDS;

CREATE TABLE public.competence(
	comp_id       SERIAL NOT NULL ,
	comp_intitule VARCHAR (50) NOT NULL ,
	comp_valide   BOOL  NOT NULL ,
	comp_id_1     INT  NOT NULL ,
	CONSTRAINT prk_constraint_competence PRIMARY KEY (comp_id)
)WITHOUT OIDS;

CREATE TABLE public.projet(
	proj_id          SERIAL NOT NULL ,
	proj_nom         VARCHAR (25) NOT NULL ,
	proj_datedebut   DATE   ,
	proj_datedefin   DATE   ,
	proj_description VARCHAR (1000)  ,
	proj_wiki_cdp    VARCHAR (1000)  ,
	proj_wiki_membre VARCHAR (1000)  ,
	proj_avancement  VARCHAR (50)  ,
	prf_id           INT  NOT NULL ,
	CONSTRAINT prk_constraint_projet PRIMARY KEY (proj_id)
)WITHOUT OIDS;

CREATE TABLE public.promotion(
	prm_id        SERIAL NOT NULL ,
	prm_intitule  VARCHAR (50) NOT NULL ,
	prm_lieu      VARCHAR (25) NOT NULL ,
	prm_datedebut DATE  NOT NULL ,
	prm_datefin   DATE  NOT NULL ,
	CONSTRAINT prk_constraint_promotion PRIMARY KEY (prm_id)
)WITHOUT OIDS;

CREATE TABLE public.action_a_notifier(
	id_notif      SERIAL NOT NULL ,
	date_envoi    TIMESTAMPTZ NOT NULL ,
	notif_validee BOOL  NOT NULL ,
	CONSTRAINT prk_constraint_action_a_notifier PRIMARY KEY (id_notif)
)WITHOUT OIDS;

CREATE TABLE public.proposition_comp(
	id_notif INT  NOT NULL ,
	comp_id  INT  NOT NULL ,
	CONSTRAINT prk_constraint_proposition_comp PRIMARY KEY (id_notif)
)WITHOUT OIDS;

CREATE TABLE public.invitation_projet(
	id_notif INT  NOT NULL ,
	proj_id  INT  NOT NULL ,
	prf_id   INT  NOT NULL ,
	CONSTRAINT prk_constraint_invitation_projet PRIMARY KEY (id_notif)
)WITHOUT OIDS;

CREATE TABLE public.candidature(
	id_notif INT  NOT NULL ,
	proj_id  INT  NOT NULL ,
	CONSTRAINT prk_constraint_candidature PRIMARY KEY (id_notif)
)WITHOUT OIDS;

CREATE TABLE public.droit(
	droit_id       SERIAL NOT NULL ,
	droit_intitule VARCHAR (25) NOT NULL ,
	CONSTRAINT prk_constraint_droit PRIMARY KEY (droit_id)
)WITHOUT OIDS;

CREATE TABLE public.travaille(
	prf_id  INT  NOT NULL ,
	proj_id INT  NOT NULL ,
	CONSTRAINT prk_constraint_travaille PRIMARY KEY (prf_id,proj_id)
)WITHOUT OIDS;

CREATE TABLE public.possede(
	comp_niveau INTEGER  NOT NULL ,
	comp_id     INT  NOT NULL ,
	prf_id      INT  NOT NULL ,
	CONSTRAINT prk_constraint_possede PRIMARY KEY (comp_id,prf_id)
)WITHOUT OIDS;

CREATE TABLE public.envoyer(
	id_notif INT  NOT NULL ,
	prf_id   INT  NOT NULL ,
	CONSTRAINT prk_constraint_envoyer PRIMARY KEY (id_notif,prf_id)
)WITHOUT OIDS;



ALTER TABLE public.profil ADD CONSTRAINT FK_profil_prm_id FOREIGN KEY (prm_id) REFERENCES public.promotion(prm_id);
ALTER TABLE public.profil ADD CONSTRAINT FK_profil_droit_id FOREIGN KEY (droit_id) REFERENCES public.droit(droit_id);
ALTER TABLE public.competence ADD CONSTRAINT FK_competence_comp_id_1 FOREIGN KEY (comp_id_1) REFERENCES public.competence(comp_id);
ALTER TABLE public.projet ADD CONSTRAINT FK_projet_prf_id FOREIGN KEY (prf_id) REFERENCES public.profil(prf_id);
ALTER TABLE public.proposition_comp ADD CONSTRAINT FK_proposition_comp_id_notif FOREIGN KEY (id_notif) REFERENCES public.action_a_notifier(id_notif);
ALTER TABLE public.proposition_comp ADD CONSTRAINT FK_proposition_comp_comp_id FOREIGN KEY (comp_id) REFERENCES public.competence(comp_id);
ALTER TABLE public.invitation_projet ADD CONSTRAINT FK_invitation_projet_id_notif FOREIGN KEY (id_notif) REFERENCES public.action_a_notifier(id_notif);
ALTER TABLE public.invitation_projet ADD CONSTRAINT FK_invitation_projet_proj_id FOREIGN KEY (proj_id) REFERENCES public.projet(proj_id);
ALTER TABLE public.invitation_projet ADD CONSTRAINT FK_invitation_projet_prf_id FOREIGN KEY (prf_id) REFERENCES public.profil(prf_id);
ALTER TABLE public.candidature ADD CONSTRAINT FK_candidature_id_notif FOREIGN KEY (id_notif) REFERENCES public.action_a_notifier(id_notif);
ALTER TABLE public.candidature ADD CONSTRAINT FK_candidature_proj_id FOREIGN KEY (proj_id) REFERENCES public.projet(proj_id);
ALTER TABLE public.travaille ADD CONSTRAINT FK_travaille_prf_id FOREIGN KEY (prf_id) REFERENCES public.profil(prf_id);
ALTER TABLE public.travaille ADD CONSTRAINT FK_travaille_proj_id FOREIGN KEY (proj_id) REFERENCES public.projet(proj_id);
ALTER TABLE public.possede ADD CONSTRAINT FK_possede_comp_id FOREIGN KEY (comp_id) REFERENCES public.competence(comp_id);
ALTER TABLE public.possede ADD CONSTRAINT FK_possede_prf_id FOREIGN KEY (prf_id) REFERENCES public.profil(prf_id);
ALTER TABLE public.envoyer ADD CONSTRAINT FK_envoyer_id_notif FOREIGN KEY (id_notif) REFERENCES public.action_a_notifier(id_notif);
ALTER TABLE public.envoyer ADD CONSTRAINT FK_envoyer_prf_id FOREIGN KEY (prf_id) REFERENCES public.profil(prf_id);
