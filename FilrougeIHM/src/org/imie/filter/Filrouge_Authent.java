
package org.imie.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Profil;

import org.imie.service.exception.ServiceException;
import org.imie.service.profil.ProfilServiceLocal;

/**
 * Servlet Filter implementation class Filrouge_Authent
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/*" })
public class Filrouge_Authent implements Filter
{

	// @EJB(beanName = "ProfilService")
	@Resource(name = "java:module/ProfilService!org.imie.service.profil.ProfilServiceLocal")
	private ProfilServiceLocal profilService;

	/**
	 * Default constructor.
	 */
	public Filrouge_Authent()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy()
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		Boolean authentified = false;
		Boolean authentifying = false;
		Boolean resourceToScan = true;
		Boolean requestInterupted = false;

		// pas besoin de scanner les css
		if (httpServletRequest.getRequestURI().contains(".css")
				|| httpServletRequest.getRequestURI().contains(".png")
				|| httpServletRequest.getRequestURI().contains(".jpg"))
		{
			resourceToScan = false;
		}
		// Si on est en Login
		if (httpServletRequest.getRequestURI().contains("Login"))
		{
			authentifying = true;
			// On intercepte de force les méthodes post et si on a validé
			if (httpServletRequest.getMethod().equals("POST")
					&& httpServletRequest.getParameter("validate") != null)
			{
				// On récupère les infos de connexion
				String Login = request.getParameter("login");
				String pass = request.getParameter("pass");
				Profil searchProfil = new Profil();
				searchProfil.setIdentConnexion(Login);
				searchProfil.setMdpConnexion(pass);
				// On teste si le profil est dans la base
				Profil authentProfil = null;
				try
				{
					authentProfil = profilService
							.verifAuthentification(searchProfil);
				}
				catch (ServiceException e)
				{
					request.setAttribute("messageException", e.getMessage());
				}
				// Si l'authentification est correcte on set le profil en
				// session
				if (authentProfil != null)
				{
					httpServletRequest.getSession().setAttribute(
							"authentifiedProfil", authentProfil);
					httpServletResponse.sendRedirect("Accueil");
				}
				// Sinon on retourne sur la page de Login
				else
				{
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("./WEB-INF/Login.jsp");
					dispatcher.forward(request, response);
				}
				// On a interrompu la requête pour que l'utilisateur se logue
				requestInterupted = true;
			}
		}
		// Si il y a un profil en session c'est que l'on est logué
		if (httpServletRequest.getSession().getAttribute("authentifiedProfil") != null)
		{
			authentified = true;
		}
		// Si on a pas interrompu la requête et que l'on est pas en
		// authentification ni authentifié et que c'est une ressource
		// a scanner alors on redirige vers la page de login
		if (!requestInterupted)
		{
			if (!authentified && !authentifying && resourceToScan)
			{
				String requestParam = httpServletRequest.getQueryString() != null ? "?"
						.concat(httpServletRequest.getQueryString()) : "";
				httpServletRequest.getSession().setAttribute(
						"originURL",
						httpServletRequest.getRequestURL().toString()
								.concat(requestParam));
				httpServletResponse.sendRedirect("/FilrougeIHM/Login");
			}
			else
			{
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
		// TODO Auto-generated method stub
	}

}
