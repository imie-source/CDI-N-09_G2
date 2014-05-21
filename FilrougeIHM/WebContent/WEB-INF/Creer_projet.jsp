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
		<h2>Créer un projet</h2>
		<div class="div_profil">
			<fieldset class="fieldset_profil">
			<legend>Créer un projet</legend>
			<table>
				<tr>
					<th>Nom du projet : </th>
					<td>
					<input class="projet_input" name="projet_name" type="text" /></td>
				</tr>
				<tr>
					<th>Descriptif : </th>
					<td><textarea class="projet_textarea"></textarea></td>
				</tr>
				<tr>
					<th>Date début (format jj/mm/aaaa) : </th>
					<td>
					<input class="projet_input" name="projet_dated" type="text" /></td>
				</tr>
				<tr>
					<th>Date fin (format jj/mm/aaaa) : </th>
					<td>
					<input class="projet_input" name="projet_datef" type="text" /></td>
				</tr>
			</table>
			<input type="button" value="Créer le projet" /> </fieldset></div>
	</div>
	<div class="footer">
		Copyright 2014 © Team S.P.A.R.K Tous droits réservés </div>
</div>

</body>

</html>
