package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmed
 */
@WebFilter("/utilisateurFiltre")
public class UtilisateurFiltre implements Filter {

    /**
     * Default constructor. 
     */
    public UtilisateurFiltre() {
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
            HttpServletRequest hrequest = (HttpServletRequest)request;
            HttpServletResponse hresponse = (HttpServletResponse) response;
            HttpSession session = hrequest.getSession();
            if (session.getAttribute("utilisateur") == null)
                hresponse.sendRedirect("Connect");
            else
            {
                Object complete = session.getAttribute("complete");
                if (complete == null || (boolean)complete)
                    chain.doFilter(request, response);
                else
                    hresponse.sendRedirect("AjouterEnfants");
            }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
