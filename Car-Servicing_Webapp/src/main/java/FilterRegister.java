
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.accenture.utils.DataValidation;

/**
 * Servlet Filter implementation class FilterRegister
 */
public class FilterRegister implements Filter {

	/**
	 * Default constructor.
	 */
	public FilterRegister() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String cpassword = req.getParameter("cpassword");
		String name = req.getParameter("personname");
		String email = req.getParameter("email");

		System.out.println("DEBUG: Filter FilterRegister received REQUEST.");

		if (username.length() == 0 || password.length() == 0 || name.length() == 0 || email.length() == 0
				|| !password.equals(cpassword)) {
			System.out.println("DEBUG: Filter Rejected Length Or Confirm Password");
		} else if (!DataValidation.validatePassword(password)) {
			System.out.println("DEBUG: Filter Rejected Password Format");
		} else if (username.length() < 8 || username.length() > 12) {
			System.out.println("DEBUG: Filter Rejected Username Format");
		}
		else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
