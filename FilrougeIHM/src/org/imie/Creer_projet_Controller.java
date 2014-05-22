
package org.imie;

import java.io.IOException;

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
 * Servlet implementation class Creer_projet_Controller
 */
@WebServlet("/Creer_projet")
public class Creer_projet_Controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Resource(name = "java:module/ProjetService!org.imie.service.projet.ProjetServiceLocal")
	private ProjetServiceLocal projetService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Creer_projet_Controller()
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

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("./WEB-INF/Creer_projet.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String nomProjet = request.getParameter("projet_name");
		if (!nomProjet.equals(""))
		{
			Projet projet = new Projet();
			projet.setNom(nomProjet);
			projetService.creerProjet(projet);
			request.setAttribute("message", "Projet Créé");
		}
		else
		{
			request.setAttribute("message",
					"Vous devez remplir au moins le nom du Projet!");
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("./WEB-INF/Creer_projet.jsp");
		dispatcher.forward(request, response);
	}

}
