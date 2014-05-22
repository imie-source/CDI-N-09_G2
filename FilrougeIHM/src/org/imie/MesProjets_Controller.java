
package org.imie;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Projet;

import org.imie.service.projet.ProjetServiceLocal;

/**
 * Servlet implementation class Projets_Controller
 */
@WebServlet("/mesprojets/*")
public class MesProjets_Controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Resource(name = "java:module/ProjetService!org.imie.service.projet.ProjetServiceLocal")
	private ProjetServiceLocal projetService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MesProjets_Controller()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		buildIHM(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

	private void buildIHM(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		Projet projetSelectionne = new Projet();
		List<Projet> projets = projetService.rechercherProjet(new Projet());
		request.removeAttribute("projets");
		request.setAttribute("projets", projets);
		// Déclaration du pattern de consultation d'un projet
		Pattern pattern = Pattern.compile(".*/Projets/([0-9]*)");
		Matcher matcher = pattern.matcher(request.getRequestURL());
		// Si il y a un id de projet dans l'id
		if (matcher.find())
		{
			projetSelectionne.setId(Integer.valueOf(matcher.group(1)));
			List<Projet> projetTrouve = projetService
					.rechercherProjet(projetSelectionne);
			if (projetTrouve.size() > 0)
			{
				projetSelectionne = projetTrouve.get(0);
			}
		}
		if (projets.size() > 0)
		{
			request.setAttribute("projetSelectionne", projetSelectionne);
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/mesProjets.jsp");
		dispatcher.forward(request, response);
	}

}
