package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import dao.ProductDAO;
import entities.Cart;
import entities.Product;
import ultilities.Constants_Value;

/**
 * Servlet implementation class AddToCartController
 */
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cart cart = new Cart();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Find session cart, if not exist then create a new one
		if (session.getAttribute(Constants_Value.SESSION_CART) == null) {
			session.setAttribute(Constants_Value.SESSION_CART, cart);
		}

		// Get product id and order quantity from form
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		int orderQuantity = Integer.parseInt(request.getParameter("quantity"));

		// Create a new product object from selected id
		Product product = new Product();

		product = ProductDAO.getProductByID(product_id);

		cart.setOrderQuantity(orderQuantity);
		cart.addToCart(product, orderQuantity); // add the product to cart

		response.sendRedirect("/CuaHangAnVat_WebServlet_2/View_HomeController");
	}

}
