<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Stack" %>
<%@ page import="model.Competence" %>

<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/FilrougeIHM/style/style.css" rel="stylesheet" />
<link href="/FilrougeIHM/style/style_menu.css" rel="stylesheet" />
<title>Compétences</title>
</head>
<body>

<div class="div_global">
	<%@include file="Header.jsp" %>
	<div class="contenu">


<%! List<Competence> competences; %>
<% competences = (List<Competence>) request.getAttribute("competences"); %>
<%--Y a mieux à faire que faire un getAttribut : les useBean --%>

<ul>
<%
	Stack<Competence> stack = new Stack<Competence>();
	// initialisation de la pile
	for (Competence competance: competences) {
		stack.push(competance);
	}
	// parcourt iteratif de l'arbre des competances
	Competence parent = null; // null pour la racine
	while (! stack.empty()) {
		Competence noeud = stack.pop();
		// si le noeud retiré de la pile n'a pas le meme parent que les noeuds precedents
		// c'est que l'on remonte dans l'arbre ; fermer la liste courante
		if (noeud.getCompetence() != parent) {
			// on change de parent
%>			</ul></li>			<%
			parent = noeud.getCompetence();
		}

%>		<li><a href=""><%= noeud.getCompIntitule() %> </a> <%
		if (noeud.getCompetences() != null && noeud.getCompetences().size() != 0) {
			// il y a des descendants => nouvelle liste
%>			<ul>	<%
			parent = noeud;
			for (Competence competence: noeud.getCompetences()) {
				stack.push(competence);
			}
		} else { // il n'y a pas de descendants => c'est une feuille
				%> </li> <%
		}		
	}

	// remonter dans l'arbre a partir de la derniere feuille affichee pour fermer les balises
	while (parent != null) {
%>		</ul></li>		<%
		parent = parent.getCompetence();
	}
%>
</ul>

	</div>
	<div class="footer">
		Copyright 2014 © Team S.P.A.R.K Tous droits réservés </div>
</div>

</body>
</html>