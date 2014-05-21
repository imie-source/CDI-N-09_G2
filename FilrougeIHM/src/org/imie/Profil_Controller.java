
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
 * Servlet implementation class Profil
 */
@WebServlet("/Profil/*")
public class Profil_Controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Resource(name = "java:module/ProfilService!org.imie.service.profil.ProfilServiceLocal")
	private ProfilServiceLocal profilService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Profil_Controller()
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

		StringBuffer url = request.getRequestURL();
		// Déclaration du pattern de consultation d'un projet
		Pattern pattern = Pattern.compile(".*/Profil/([0-9]+)");
		Matcher matcher = pattern.matcher(url);

		Profil profilAAfficher = new Profil();

		// Si il y a un id de projet dans l'id
		if (matcher.find())
		{
			Integer id = Integer.valueOf(matcher.group(1));

			profilAAfficher.setId(id);
			List<Profil> result = profilService
					.rechercherProfil(profilAAfficher);
			if (!result.isEmpty())
			{
				profilAAfficher = result.get(0);
				String titre = profilAAfficher.getPrenom().concat(" ")
						.concat(profilAAfficher.getNom());
				request.setAttribute("titre", titre);
			}
			else
			{
				profilAAfficher = (Profil) request.getSession().getAttribute(
						"authentifiedProfil");
			}
		}
		else
		{
			profilAAfficher = (Profil) request.getSession().getAttribute(
					"authentifiedProfil");
		}

		request.setAttribute("profilAAfficher", profilAAfficher);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/Profil.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		Profil profilUpdate = new Profil();
		Integer id = Integer.valueOf(request.getParameter("id"));
		profilUpdate.setId(id);
		profilUpdate = profilService.rechercherProfil(profilUpdate).get(0);

		String infos = request.getParameter("infos");
		if (infos != null)
		{
			profilUpdate.setInfos(infos);
		}

		profilUpdate = profilService.mettreAJourProfil(profilUpdate);
		request.setAttribute("profilAAfficher", profilUpdate);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/Profil.jsp");
		dispatcher.forward(request, response);
	}
}
