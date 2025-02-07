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
@WebFilter("/adminFiltre")
public class AdminFiltre implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFiltre() {
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
            if (session.getAttribute("utilisateur") == null || !(boolean)session.getAttribute("isAdmin"))
                hresponse.sendRedirect("Connect");
            else
                chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
            // TODO Auto-generated method stub
	}

}
