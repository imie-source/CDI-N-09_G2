<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/FilrougeIHM/style/style.css" rel="stylesheet" />
<link href="/FilrougeIHM/style/style_menu.css" rel="stylesheet" />
<title>Profil</title>
</head>
<body>
<div class="div_global">
<%@include file="Header.jsp" %>
	<div class="contenu">
		<h2>Mon profil</h2>
		<div class="div_profil">
			<div class="div_photo">
				<img alt="" class="img_photo" src="/FilrougeIHM/style/images/the-mask.jpg" width="130px" />
			</div>
				
				
			<div class="div_contenu_profil">
	
				<div class="row_profil">
					<label class="label_profil">Login : </label><label>TODO</label>
				</div>
				
				<div class="row_profil">
				<label class="label_profil">Mot de passe : </label>
				<a class="a_profil" href="#">TODO</a>
				</div>
				
				<div class="row_profil">
					<label>TODO Prenom NOM</label>				
				</div>
	
				<div class="row_profil">
					<label>TODO age</label>
				</div>
				
				<div class="row_profil">
					<label>TODO ville</label>
					<a class="a_profil2" href="#">Modifier</a>
					<input name="Checkbox1" type="checkbox" />
					<label class="a_profil2">Masquer cette information</label>
				</div>
			
				<div class="row_profil">
					<label>TODO mail</label>
					<a class="a_profil2" href="#">Modifier</a>
					<input checked="checked" name="Checkbox1" type="checkbox" />
					<label class="a_profil2">Masquer cette information</label>
				</div>
				
				<div class="row_profil">
					<label>TODO tel</label>
					<a class="a_profil2" href="#">Modifier</a>	
					<input checked="checked" name="Checkbox1" type="checkbox" />
					<label class="a_profil2">Masquer cette information</label>
				</div>
				
				
				<div class="row_profil">
					<label class="label_profil">Promotion : </label>
					<label>TODO PROMO</label>
				</div>
				
				
				<div class="row_profil">
					<label class="label_profil">Lieu de formation :</label>
					<label>TODO ville</label>
				</div>
				
				<div class="row_profil">
					<label class="label_profil">Disponibilité : </label>
					<input checked="checked" name="Radio1" type="radio" />
					<label> oui</label>
					<input name="Radio1" type="radio" />
					<label> non</label>
				</div>

			</div>
			
			<br />
			<br />
			
			
			<div id="shadow" class="shadow">
				<label class="label_close" onclick="cache_shadow()">X</label>
				<div id="cssmenu2">
					<ul>
						<li class="has-sub"><a href="#"><span>Informatique</span></a>
						<ul>
							<li class="has-sub"><a href="#"><span>EDI</span></a>
							<ul>
								<li><a href="#"><span>Visual Studio</span></a></li>
								<li><a href="#"><span>Eclipse</span></a></li>
								<li><a href="#"><span>WinDev</span></a></li>
								<li><a href="#"><span>WebDev</span></a></li>
								<li class="last"><a href="#"><span>WinDev Mobile</span></a></li>
							</ul>
							</li>
						</ul>
						</li>
						<li class="has-sub last"><a href="#"><span>Langages</span></a>
						<ul>
							<li><a href="#"><span>ActionScript</span></a></li>
							<li><a href="#"><span>ASP.NET</span></a></li>
							<li><a href="#"><span>C++</span></a></li>
							<li><a href="#"><span>C#</span></a></li>
							<li><a href="#"><span>COBOL</span></a></li>
							<li><a href="#"><span>Delphi</span></a></li>
							<li><a href="#"><span>F#</span></a></li>
							<li><a href="#"><span>J#</span></a></li>
							<li><a href="#"><span>J++</span></a></li>
							<li><a href="#"><span>Java</span></a></li>
							<li><a href="#"><span>JavaScript</span></a></li>
							<li><a href="#"><span>PHP</span></a></li>
							<li><a href="#"><span>HTML</span></a></li>
							<li><a href="#"><span>VBA</span></a></li>
							<li class="has-sub"><a href="#"><span>Visual Basic</span></a>
							<ul>
								<li><a href="#"><span>VB6</span></a></li>
								<li class="last"><a href="#"><span>VB.Net</span></a></li>
							</ul>
							</li>
						</ul>
						</li>
					</ul>
				</div>
			</div>
			
			<fieldset class="fieldset_profil">
			<legend>Information Complémentaire</legend>
			<textarea rows="15" cols="75">
			</textarea>
			</fieldset>
			
			<fieldset class="fieldset_profil">
			<legend>Mes Compétences</legend>
			<input onclick="affich_shadow()" type="button" value="Ajouter une compétence" />
			<table class="table_comp_profil">
				<tr>
					<td>VB.net</td>
					<td><img alt="" src="images/source/etoile4.png" /></td>
					<td>JavaScript</td>
					<td><img alt="" src="images/source/etoile4.png" /></td>
					<td>C#</td>
					<td><img alt="" src="images/source/etoile3.png" /></td>
				</tr>
				<tr>
					<td>HTML5</td>
					<td><img alt="" src="images/source/etoile5.png" /></td>
					<td>SQL</td>
					<td><img alt="" src="images/source/etoile3.png" /></td>
					<td>PL/SQL</td>
					<td><img alt="" src="images/source/etoile3.png" /></td>
				</tr>
				<tr>
					<td>CSS3</td>
					<td><img alt="" src="images/source/etoile5.png" /></td>
					<td>VBS</td>
					<td><img alt="" src="images/source/etoile4.png" /></td>
					<td>VB6</td>
					<td><img alt="" src="images/source/etoile4.png" /></td>
				</tr>
				<tr>
					<td>Java</td>
					<td><img alt="" src="images/source/etoile3.png" /></td>
					<td>Perl</td>
					<td><img alt="" src="images/source/etoile2.png" /></td>
					<td>Python</td>
					<td><img alt="" src="images/source/etoile2.png" /></td>
				</tr>
			</table>
			</fieldset>
			
			<input name="submit" type="submit" value="Enregistrer les modifications" />
			
		</div>
	</div>

</div>

</body>
</html>