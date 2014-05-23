<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<link href="/FilrougeIHM/style/style.css" rel="stylesheet" />
<link href="/FilrougeIHM/style/style_menu.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/FilrougeIHM/js/bootstrap-progressbar-3.1.0.css">
<script type="text/javascript" src="/FilrougeIHM/js/jquery-1.10.2.js"></script>
<script type='text/javascript' src="/FilrougeIHM/js/tinymce.min.js"></script>
<script type='text/javascript' src="/FilrougeIHM/js/bootstrap-3.1.0.min.js"></script>
<script type='text/javascript' src="/FilrougeIHM/js/bootstrap-progressbar.js"></script>
<script>
        $(document).ready(function() {
	        tinymce.init({
	            selector:'textarea.editable',
	            inline:true,
	            plugins: [
	                      "advlist autolink lists link charmap preview anchor",
	                      "searchreplace visualblocks fullscreen",
	                      "table contextmenu paste"],
	            toolbar: "insertfile undo redo | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist | link"});
            $('.progress-bar').progressbar({use_percentage: false});
        });
	 
</script>

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
							<c:url value="${uri }${projet.id }" var="urlProjet"></c:url>
							<td><a href="${urlProjet}"><c:out value="${projet.nom }"></c:out></a></td>
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
		<div class="detail_projet">
			<fieldset class="fieldset_projet">
				<legend>Créer un projet</legend>
				<table id="table_proj">
					<tr>
						<th>Nom du projet : </th>
						<td>
							<label><c:out value="${projetSelectionne.nom }"></c:out></label>
						</td>
					</tr>
					<tr>
						<th>Descriptif : </th>
						<td>
							<textarea class="editable" contenteditable="false"><c:out value="${projetSelectionne.description }"></c:out></textarea>
						</td>
					</tr>
					<tr>
						<th>Date de début : </th>
						<td>
							<label>
								<c:set var="date" value="${projetSelectionne.datedebut }" />
										<fmt:formatDate pattern="dd/MM/yyyy" value="${date }"/>
							</label>
						</td>
					</tr>
					<tr>
						<th>Date de fin prévue : </th>
						<td>
							<label>
								<c:set var="date" value="${projetSelectionne.datedefin }" />
										<fmt:formatDate pattern="dd/MM/yyyy" value="${date }"/>
							</label>
						</td>
					</tr>
					<tr>
						<th>Wiki Chef de Projet </th>
						<td>
							<textarea class="editable" contenteditable="false" id="wiki1">${projetSelectionne.wikiCdp }</textarea>
							
						</td>
					</tr>
					<tr>
						<th>Wiki Membre </th>
						<td>
							<textarea class="editable" contenteditable="false" id="wiki1">${projetSelectionne.wikiMembre }</textarea>
							
						</td>
					</tr>
				</table>
				
<!-- 				<input type="button" value="Postuler" onclick="alert($('#wiki1').html())"/> -->
			</fieldset>
		</div>
	</div>
	<div class="footer">Copyright 2014 © Team S.P.A.R.K Tous droits réservés </div>
</div>

</body>

</html>
