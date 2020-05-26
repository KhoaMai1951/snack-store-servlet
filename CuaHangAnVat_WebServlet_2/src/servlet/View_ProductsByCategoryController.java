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
 * Servlet implementation class View_ProductsByCategoryController
 */
@WebServlet("/View_ProductsByCategoryController")
public class View_ProductsByCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cart cart = new Cart();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public View_ProductsByCategoryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int categoryID = Integer.parseInt(request.getParameter("category_id"));

		// get products by category
		request.setAttribute("productList", ProductDAO.getProductsByCategory(categoryID));
		// get all categories
		request.setAttribute("categoryList", CategoryDAO.getAll());
		// get session
		if (request.getSession().getAttribute(Constants_Value.SESSION_CART) != null) {
			cart = (Cart) request.getSession().getAttribute(Constants_Value.SESSION_CART);
			request.setAttribute("items", cart.getItems());
			request.setAttribute("sumPrice", cart.getSumPrice());
		}

		request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
