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
<title>Accueil</title>
</head>

<body>

<div class="div_global">
	<%@include file="Header.jsp" %>
	<div class="contenu">
		<h2>Accueil - Derniers Projets Ajoutés</h2>
		<table align="center" border="2" class="table_projets">
			<thead>
				<tr>
					<th>Nom du projet</th>
					<th>Descriptif</th>
					<th>Date de début</th>
					<th>Date de fin</th>
					<th>Avancement du projet</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach var="projet" items="${ projets }">
			
					<tr>
						<td><c:out value="${projet.projNom }"></c:out></td>
						<td><c:out value="${projet.projDescription }"></c:out></td>
						<td><c:set var="date" value="${projet.projDatedebut }" />
							<fmt:formatDate pattern="dd/MM/yyyy" value="${date }"/></td>
						<td><c:set var="date" value="${projet.projDatedefin }" />
							<fmt:formatDate pattern="dd/MM/yyyy" value="${date }"/></td>
						<td><img alt="" height="30" src="/FilrougeIHM/style/images/pb0.png" /></td>
					</tr>
					
				</c:forEach>
				
			</tbody>
		</table>
	</div>
	<div class="footer">
		Copyright 2014 © Team S.P.A.R.K Tous droits réservés </div>
</div>

</body>

</html>
