//package filter;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import ultilities.Constants_Value;
//
///**
// * Servlet Filter implementation class Admin_Filter
// */
//@WebFilter({"/admin/*"})
//public class Admin_Filter implements Filter
//{
//
//	/**
//	 * Default constructor.
//	 */
//	public Admin_Filter()
//	{
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy()
//	{
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException
//	{
//		// TODO Auto-generated method stub
//		// place your code here
//
//		HttpServletResponse res = (HttpServletResponse) response;
//		HttpServletRequest req = (HttpServletRequest) request;
//
//		HttpSession session = req.getSession(true);
//
//		if (session.getAttribute(Constants_Value.IS_ADMIN_LOGIN) == null)
//		{
//			res.sendRedirect(req.getContextPath() + Constants_Value.LOGIN_URL);
//		}
//		else
//		{
//			chain.doFilter(request, response);
//		}
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException
//	{
//		// TODO Auto-generated method stub
//	}
//
//}
