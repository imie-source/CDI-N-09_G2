-- pour renommer  les clefs etangeres des tables profil et projet
alter table profil rename column prm_id to prf_prm_id;
alter table profil rename column droit_id to prf_droit_id;
alter table projet rename column prf_id to proj_prf_id;
-- pour mettre la possibilité NULL a certaines clefs etrangères
alter table competence alter column comp_id_1 drop not null;
alter table profil alter column prf_prm_id drop not null;
alter table projet alter column proj_prf_id drop not null;
