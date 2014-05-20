
package org.imie;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/Projets/*")
public class Projets_Controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Resource(name = "java:module/ProjetService!org.imie.service.projet.ProjetServiceLocal")
	private ProjetServiceLocal projetService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Projets_Controller()
	{
		super();
		// TODO Auto-generated constructor stub
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
		List<Projet> projets = projetService.rechercherProjet(new Projet());
		request.removeAttribute("projets");
		request.setAttribute("projets", projets);
		if (projets.size() > 0)
		{
			request.setAttribute("projetSelectionne", projets.get(0));
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("./WEB-INF/Projets.jsp");
		dispatcher.forward(request, response);
	}

}
