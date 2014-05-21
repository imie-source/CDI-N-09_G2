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
	<div class="contenu" >
		<h2>Projets</h2>
		<div class="table">
			<table class="table_projets">
				<thead>
					<tr>
						<th>Nom du projet</th>
						<th>Date de début</th>
						<th>Date de fin</th>
						<th>Avancement du projet</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="projet" items="${ projets }">
				
						<tr>
							<c:url value="/Projets/${projet.projId }" var="urlProjet"></c:url>
							<td><a href="${urlProjet}"><c:out value="${projet.projNom }"></c:out></a></td>
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
		<div class="detail_projet">
			<fieldset class="fieldset_projet">
				<legend>Créer un projet</legend>
				<table>
					<tr>
						<th>Nom du projet : </th>
						<td>
							<label><c:out value="${projetSelectionne.projNom }"></c:out></label>
						</td>
					</tr>
					<tr>
						<th>Descriptif : </th>
						<td>
							<textarea class="projet_textarea" contenteditable="false"><c:out value="${projetSelectionne.projDescription }"></c:out></textarea>
						</td>
					</tr>
					<tr>
						<th>Date de début : </th>
						<td>
							<label>
								<c:set var="date" value="${projetSelectionne.projDatedebut }" />
										<fmt:formatDate pattern="dd/MM/yyyy" value="${date }"/>
							</label>
						</td>
					</tr>
					<tr>
						<th>Date de fin prévue : </th>
						<td>
							<label>
								<c:set var="date" value="${projetSelectionne.projDatedefin }" />
										<fmt:formatDate pattern="dd/MM/yyyy" value="${date }"/>
							</label>
						</td>
					</tr>
				</table>
				<input type="button" value="Postuler" />
			</fieldset>
		</div>
	</div>
	<div class="footer">Copyright 2014 © Team S.P.A.R.K Tous droits réservés </div>
</div>

</body>

</html>
