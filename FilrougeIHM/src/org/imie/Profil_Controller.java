
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

import model.Profil;

import org.imie.service.profil.ProfilServiceLocal;

/**
 * Servlet implementation class Profil
 */
@WebServlet("/Profil")
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

		List<Profil> profils = profilService.rechercherProfil(new Profil());
		request.setAttribute("profils", profils);
		if (profils.size() > 0)
		{
			request.setAttribute("profilAAfficher", profils.get(0));
		}

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
		// TODO Auto-generated method stub
	}

}
