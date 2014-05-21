
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

import model.Profil;

import org.imie.service.profil.ProfilServiceLocal;

/**
 * Servlet implementation class Gerer_profils
 */
@WebServlet("/Gerer_profils/*")
public class Gerer_profils_Controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Resource(name = "java:module/ProfilService!org.imie.service.profil.ProfilServiceLocal")
	private ProfilServiceLocal profilService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Gerer_profils_Controller()
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
		Boolean erreur = true;

		// declaration pattern create
		Pattern patternCreate = Pattern.compile(".*/Gerer_profils/create");
		Matcher matcherCreate = patternCreate.matcher(request.getRequestURL());
		// declaration pattern read
		Pattern patternRead = Pattern.compile(".*/Gerer_profils/read/([0-9]*)");
		Matcher matcherRead = patternRead.matcher(request.getRequestURL());
		// declaration pattern update
		Pattern patternUpdate = Pattern
				.compile(".*/Gerer_profils/update/([0-9]*)");
		Matcher matcherUpdate = patternUpdate.matcher(request.getRequestURL());
		// declaration pattern delete
		Pattern patternDelete = Pattern
				.compile(".*/Gerer_profils/delete/([0-9]*)");
		Matcher matcherDelete = patternDelete.matcher(request.getRequestURL());
		if (matcherCreate.find())
		{
			System.out.println("Gerer_profils doGet create");
		}
		else if (matcherRead.find())
		{
			System.out.println("Gerer_profils doGet read ["
					+ matcherRead.group(1) + "]");
		}
		else if (matcherUpdate.find())
		{
			System.out.println("Gerer_profils doGet update ["
					+ matcherUpdate.group(1) + "]");
			Integer id = Integer.valueOf(matcherUpdate.group(1));
			Profil profilSearched = new Profil();
			profilSearched.setId(id);
			List<Profil> profils = profilService
					.rechercherProfil(profilSearched);
			if (profils.size() > 0)
			{

				erreur = false;
				response.sendRedirect("/FilrougeIHM/Profil/"
						+ matcherUpdate.group(1));

			}
		}
		else if (matcherDelete.find())
		{
			System.out.println("Gerer_profils doGet delete "
					+ matcherDelete.group(1));
		}
		// en cas d'erreur on va à la page par defaut ; la liste des profils
		if (erreur)
		{
			List<Profil> profils = profilService.rechercherProfil(new Profil());
			request.setAttribute("profils", profils);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/Gerer_profils.jsp");
			dispatcher.forward(request, response);
		}
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

}
