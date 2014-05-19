
package org.imie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Projet;

import org.imie.service.projet.ProjetServiceLocal;

/**
 * Servlet implementation class Accueil_Controller
 */
@WebServlet("/Accueil")
public class Accueil_Controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@EJB(beanName = "ProjetService")
	private ProjetServiceLocal projetService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Accueil_Controller()
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
		buildIHM(request, response);
	}

	private void buildIHM(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		List<Projet> projets = projetService.rechercherProjet(new Projet());
		List<Projet> projetsAffiches = new ArrayList<Projet>();
		for (int i = 1; i < 7; i++)
		{
			if (projets.get(i) != null)
			{

				projetsAffiches.add(projets.get(projets.size() - i));
			}
		}
		request.setAttribute("projets", projetsAffiches);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("./WEB-INF/Accueil.jsp");
		dispatcher.forward(request, response);
	}

}
