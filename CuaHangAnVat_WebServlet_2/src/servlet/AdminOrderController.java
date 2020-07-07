package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dao.OrderStatusDAO;
import entities.Order;

/**
 * Servlet implementation class AdminOrderController
 */
@WebServlet(urlPatterns =
{ "/admin/order", "/admin/order/handle" })
public class AdminOrderController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public AdminOrderController()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getServletPath();
		switch (action)
		{
		case "/admin/order":
			request.setAttribute("orderList", OrderDAO.getAll());
			request.getRequestDispatcher("/pages/orderManagement.jsp").forward(request, response);
			break;
		case "/admin/order/handle":
			request.setAttribute("orderStatusList", OrderStatusDAO.getAll());
			request.setAttribute("order", OrderDAO.getById(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("/pages/orderUpdate.jsp").forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getServletPath();
		int orderStatusId = 0;
		Date deliveredDate;
		int id =0;
		switch (action)
		{
		case "/admin/order/handle":
			deliveredDate = Date.valueOf(request.getParameter("deliveredDate"));
			orderStatusId = Integer.parseInt(request.getParameter("orderStatusId"));
			id = Integer.parseInt(request.getParameter("id"));
			OrderDAO.update(deliveredDate, orderStatusId, id);
			response.sendRedirect(request.getContextPath() + "/admin/order");
			break;
		}
	}

}
