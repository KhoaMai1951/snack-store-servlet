package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDAO;
import ultilities.Constants_Value;

/**
 * Servlet implementation class View_LoginServlet
 */
@WebServlet(urlPatterns =
{ Constants_Value.LOGIN_URL })
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		request.getRequestDispatcher(Constants_Value.FILE_LOGIN_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		AdminDAO adminDAO = new AdminDAO();
		if (adminDAO.checkUsernameAndPassword(username, password))
		{
			session.setAttribute(Constants_Value.IS_ADMIN_LOGIN, 1);
			response.sendRedirect(request.getContextPath() + Constants_Value.ADMIN_PRODUCT_MANAGER_URL);
		}
		else
		{
			request.setAttribute("message", "Password hoặc tên đăng nhập sai!");
			request.getRequestDispatcher(Constants_Value.FILE_LOGIN_URL).forward(request, response);
		}
	}

}
