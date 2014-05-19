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
	<%@include file="Header.jsp" %>
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
