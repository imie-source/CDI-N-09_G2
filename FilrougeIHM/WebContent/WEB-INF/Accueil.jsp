<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<link href="/FilrougeIHM/style/style.css" rel="stylesheet" />
<link href="/FilrougeIHM/style/style_menu.css" rel="stylesheet" />
<title>Untitled 1</title>
</head>

<body>

<div class="div_global">
	<div class="header">
		<img alt="" src="/FilrougeIHM/style/images/logo_imie2.png" />
		<div class="notification">
			<img alt="" src="/FilrougeIHM/style/images/icons/power.png" width="30px" />
			<label class="label_log">
			<c:out value="${authentifiedProfil.nom }"></c:out> - <c:out value="${authentifiedProfil.prenom }"></c:out> 
			</label><br />
			<img alt="" src="/FilrougeIHM/style/images/icons/letterv.png" width="40"><div class="compt_notif">
				3</div>
		</div>
		<br />
		<br />
		<br />
		<div class="menu">
			<div id="cssmenu">
				<ul>
					<li><a href="accueil.html"><span>Accueil</span></a></li>
					<li><a href="projets.html"><span>Projets</span></a></li>
					<li><a href="etudiants.html"><span>Etudiants</span></a></li>
					<li class="has-sub"><a href="#"><span>Administration</span></a>
					<ul>
						<li><a href="creer_projet.html"><span>Créer un projet</span></a></li>
						<li><a href="gerer_competence.html"><span>Gérer les compétences</span></a></li>
						<li><a href="importer_fichier.html"><span>Importer un fichier 
						Excel</span></a></li>
						<li class="last"><a href="gerer_profils.html"><span>Gérer 
						les profils</span></a></li>
					</ul>
					</li>
					<li class="has-sub"><a href="#"><span>Mes Projets</span></a>
					<ul>
						<li><a href="chef_de_projet.html"><span>Chef de projet</span></a></li>
						<li class="last"><a href="participant.html"><span>Participant</span></a></li>
					</ul>
					</li>
					<li><a href="profil.html"><span>Mon Profil</span></a></li>
					<li class="last"><a href="deconnexion.html"><span>Déconnexion</span></a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="contenu">
		<h2>Accueil - Derniers Projets Ajoutés</h2>
		<table align="center" border="2" class="table_projets">
			<tr>
				<th>Nom du projet</th>
				<th>Descriptif</th>
				<th>Date de début</th>
				<th>Date de fin</th>
				<th>Avancement du projet</th>
			</tr>
			<tr>
				<td>Projet 1</td>
				<td>Blablabla</td>
				<td>13/03/2014</td>
				<td>13/08/2014</td>
				<td><img alt="" height="30" src="/FilrougeIHM/style/images/pb0.png" /></td>
			</tr>
			<tr>
				<td>Projet 2</td>
				<td>Blablabla</td>
				<td>13/03/2014</td>
				<td>13/08/2014</td>
				<td><img alt="" height="30" src="/FilrougeIHM/style/images/pb0.png" /></td>
			</tr>
			<tr>
				<td>Projet 3</td>
				<td>Blablabla</td>
				<td>13/03/2014</td>
				<td>13/08/2014</td>
				<td><img alt="" height="30" src="/FilrougeIHM/style/images/pb1.png" /></td>
			</tr>
			<tr>
				<td>Projet 4</td>
				<td>Blablabla</td>
				<td>13/03/2014</td>
				<td>13/08/2014</td>
				<td><img alt="" height="30" src="/FilrougeIHM/style/images/pb1.png" /></td>
			</tr>
			<tr>
				<td>Projet 5</td>
				<td>Blablabla</td>
				<td>13/03/2014</td>
				<td>13/08/2014</td>
				<td><img alt="" height="30" src="/FilrougeIHM/style/images/pb1.png" /></td>
			</tr>
			<tr>
				<td>Projet 6</td>
				<td>Blablabla</td>
				<td>13/03/2014</td>
				<td>13/08/2014</td>
				<td><img alt="" height="30" src="/FilrougeIHM/style/images/pb2.png" /></td>
			</tr>
		</table>
	</div>
	<div class="footer">
		Copyright 2014 © Team S.P.A.R.K Tous droits réservés </div>
</div>

</body>

</html>
