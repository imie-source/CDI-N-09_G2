<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/FilrougeIHM/style/style.css" rel="stylesheet" />
<link href="/FilrougeIHM/style/style_menu.css" rel="stylesheet" />
<title>Gestion des Profils</title>
</head>
<body>

<div class="div_global">
	<%@include file="Header.jsp" %>
	<div class="contenu">
		<h2>Gérer les profils</h2>
		<input name="seach_name" style="width: 200px" type="text" /><input class="input" name="submit" type="submit" value="Rechercher" />
		<br />
		<br />
		<table align="center" border="2" class="table_projets">
			<tr>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Promotion</th>
				<th colspan="3"></th>
			</tr>
			<c:forEach var="profil" items="${ profils }">
				<tr>
					<td><c:out value="${profil.nom}"></c:out></td>
					<td><c:out value="${profil.prenom}"></c:out></td>
					<td><c:out value="${profil.promotion.prmIntitule}"></c:out></td>
					<td>
						<a href="/FilrougeIHM/Gerer_profils/read/${profil.id}">
							<img alt="" src="/FilrougeIHM/style/images/icons/eye.png" title="Voir le profil" width="25" />
						</a>
					</td>
					<td>
						<a href="/FilrougeIHM/Gerer_profils/update/${profil.id}">
							<img alt="" src="/FilrougeIHM/style/images/icons/highlight.png" title="Editer le profil" width="25" />
						</a>
					</td>
					<td>
						<a href="/FilrougeIHM/Gerer_profils/delete/${profil.id}">
							<img alt="" src="/FilrougeIHM/style/images/icons/cancel.png" title="Supprimer le profil" width="25" />
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="footer">
		Copyright 2014 © Team S.P.A.R.K Tous droits réservés </div>
</div>

</body>
</html>