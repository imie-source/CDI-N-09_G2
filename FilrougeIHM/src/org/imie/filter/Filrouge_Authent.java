package org.imie.filter;

import java.io.IOException;

import javax.ejb.EJB;
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
import org.imie.service.profil.ProfilService;

/**
 * Servlet Filter implementation class Filrouge_Authent
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST}, urlPatterns = { "/*" })
public class Filrouge_Authent implements Filter {

	@EJB(beanName="ProfileService")
	private ProfilService profilService;
	
    /**
     * Default constructor. 
     */
    public Filrouge_Authent() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		Boolean authentified = false;
		Boolean authentifying = false;
		Boolean resourceToScan = true;
		Boolean requestInterupted = false;
		
		// pas besoin de scanner les css
		if (httpServletRequest.getRequestURI().contains("css"))
		{
			resourceToScan = false;
		}
		// Si on est en Login
		if (httpServletRequest.getRequestURI().contains("Login"))
		{
			authentifying = true;
			// On intercepte de force les mthodes post
			if (httpServletRequest.getMethod().equals("POST") && httpServletRequest.getParameter("validate") != null)
			{
				String Login = request.getParameter("login");
				String pass = request.getParameter("pass");
				Profil searchProfil = new Profil();
				searchProfil.setIdentConnexion(Login);
				searchProfil.setMdpConnexion(pass);
				Profil authentProfil = null;
				try {
					authentProfil = profilService.verifAuthentification(searchProfil);
				} catch (ServiceException e) {
					request.setAttribute("messageException", e.getMessage());
				}
				if (authentProfil != null) 
				{
					httpServletRequest.getSession().setAttribute("authentifiedProfil", authentProfil);
					httpServletResponse.sendRedirect("Accueil");
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/Login.jsp");
					dispatcher.forward(request, response);
				}
				requestInterupted = true;
			}
		}
		if (httpServletRequest.getSession().getAttribute("authentifiedProfil") != null)
		{
			authentified = true;
		}
		if (!requestInterupted)
		{
			if (!authentified && !authentifying && resourceToScan)
			{
				String requestParam = httpServletRequest.getQueryString() != null ? "?".concat(httpServletRequest.getQueryString()):"";
				httpServletRequest.getSession().setAttribute("originURL", 
						httpServletRequest.getRequestURL().toString().concat(requestParam));
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
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
