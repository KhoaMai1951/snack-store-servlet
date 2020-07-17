package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.ProductDAO;
import entities.Cart;
import ultilities.Constants_Value;

/**
 * Servlet implementation class HomeViewController
 */
@WebServlet(urlPatterns =
{Constants_Value.HOME_CATEGORY_URL, Constants_Value.HOME_INDEX_URL})
public class HomeController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	Cart cart = new Cart();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController()
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
		String action = request.getServletPath();
		switch (action)
		{
		case Constants_Value.HOME_INDEX_URL:
			// get all products
			request.setAttribute("productList", ProductDAO.getAll());
			// get all categories
			request.setAttribute("categoryList", CategoryDAO.getAll());
			// get the current cart
			doGet_GetCart(request, response);
			request.getRequestDispatcher(Constants_Value.FILE_HOME_INDEX_URL).forward(request, response);
			break;
		case Constants_Value.HOME_CATEGORY_URL:
			// get products by category
			int categoryID = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("productList", ProductDAO.getProductsByCategory(categoryID));
			// get all categories
			request.setAttribute("categoryList", CategoryDAO.getAll());
			// get the current cart
			doGet_GetCart(request, response);
			request.getRequestDispatcher(Constants_Value.FILE_HOME_INDEX_URL).forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		
	}

	protected void doGet_GetCart(HttpServletRequest request, HttpServletResponse response)
	{
		// get session
		if (request.getSession().getAttribute(Constants_Value.SESSION_CART) != null)
		{
			cart = (Cart) request.getSession().getAttribute(Constants_Value.SESSION_CART);
			request.setAttribute("items", cart.getItems()); // get items in cart
			request.setAttribute("sumPrice", cart.getSumPrice()); // get sum price
		}
	}
}
