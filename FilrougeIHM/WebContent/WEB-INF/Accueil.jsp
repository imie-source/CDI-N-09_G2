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
<link rel="stylesheet" type="text/css" href="/FilrougeIHM/js/bootstrap-progressbar-3.1.0.css">
<script type="text/javascript" src="/FilrougeIHM/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/FilrougeIHM/js/tinymce.min.js"></script>
<script type='text/javascript' src="/FilrougeIHM/js/bootstrap-3.1.0.min.js"></script>
<script type='text/javascript' src="/FilrougeIHM/js/bootstrap-progressbar.js"></script>
<script>
        $(document).ready(function() {
            $('.progress-bar').progressbar({use_percentage: false});
        });
	 
</script>
<title>Accueil</title>
</head>

<body>

<div class="div_global">
	<%@include file="Header.jsp" %>
	<div class="contenu">
		<h2>Accueil - Derniers Projets Ajoutés</h2>
		<table align="center" class="table_projets">
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
						<td><c:out value="${projet.nom }"></c:out></td>
						<td><c:out value="${projet.description }"></c:out></td>
						<td><c:set var="date" value="${projet.datedebut }" />
							<fmt:formatDate pattern="dd/MM/yyyy" value="${date }"/></td>
						<td><c:set var="date" value="${projet.datedefin }" />
							<fmt:formatDate pattern="dd/MM/yyyy" value="${date }"/></td>
						<td>
							<div class="progress progress-striped active">
							    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuetransitiongoal="${projet.avancement }"></div>
							</div>
						</td>
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
