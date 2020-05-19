package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import dao.OrderDAO;
import entities.Cart;
import ultilities.Constants_Value;

/**
 * Servlet implementation class CheckoutController
 */
@WebServlet("/CheckoutController")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cart cart = new Cart();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckoutController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get parameters
		String customerName = request.getParameter("customer_name");
		String customerEmail = request.getParameter("customer_email");
		String customerAddress = request.getParameter("customer_address");
		String customerPhone = request.getParameter("customer_phone");
		String customerSessionID = UUID.randomUUID().toString();
		// get session
		if (request.getSession().getAttribute(Constants_Value.SESSION_CART) != null) {
			cart = (Cart) request.getSession().getAttribute(Constants_Value.SESSION_CART);
		}
		
		try {
			//add customer to database
			CustomerDAO.add(customerName, customerEmail, customerAddress, 
					customerPhone, customerSessionID);
			//add order to database and link customer session id to order's customer_id
			OrderDAO.add(customerSessionID);
			//add list of ordered products to database
			for(int i=0; i < cart.getItems().size(); i++)
			{
				Product
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
