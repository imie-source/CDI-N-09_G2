
package org.imie;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Competence;

import org.imie.service.competence.CompetenceServiceLocal;

/**
 * Servlet implementation class Competences_Controller
 */
@WebServlet("/Competences")
public class Competences_Controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Resource(name = "java:module/CompetenceService!org.imie.service.competence.CompetenceServiceLocal")
	private CompetenceServiceLocal competenceService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Competences_Controller()
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
		ServletContext context = request.getSession().getServletContext();

		List<Competence> competences = competenceService.skillsTree(true);
		request.setAttribute("competences", competences);

		RequestDispatcher dispatcher = context
				.getRequestDispatcher("/WEB-INF/Competences.jsp");
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
