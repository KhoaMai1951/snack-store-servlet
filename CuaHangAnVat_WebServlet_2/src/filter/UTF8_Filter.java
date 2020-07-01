package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class UTF8_Filter
 */
@WebFilter(value = "/*")
public class UTF8_Filter implements Filter
{

	private String encoding = "utf-8";

	/**
	 * Default constructor.
	 */
	public UTF8_Filter()
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		// Cho phép request được đi tiếp. (Vượt qua Filter này).

		chain.doFilter(request, response);

	}


}
