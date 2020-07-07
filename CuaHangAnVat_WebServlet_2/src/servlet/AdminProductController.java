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

/**
 * Servlet implementation class View_ProductManagementController
 */
@WebServlet(urlPatterns =
{ "/admin/product", "/admin/product/edit", "/admin/product/delete", "/admin/product/add" })
public class AdminProductController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminProductController()
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
		String action = request.getServletPath();
		switch (action)
		{
		case "/admin/product":
			request.setAttribute("categoryList", CategoryDAO.getAll());
			request.setAttribute("productList", ProductDAO.getAll());
			// get session
			if (request.getSession().getAttribute("cart") != null)
			{
				Cart cart = (Cart) request.getSession().getAttribute("cart");
				request.setAttribute("items", cart.getItems());
				request.setAttribute("sumPrice", cart.getSumPrice());
			}
			request.getRequestDispatcher("/pages/productManagement.jsp").forward(request, response);
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
