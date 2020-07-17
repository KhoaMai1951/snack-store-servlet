package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dao.OrderStatusDAO;
import dao.ProductDAO;
import ultilities.Constants_Value;

/**
 * Servlet implementation class AdminOrderController
 */
@WebServlet(urlPatterns =
{Constants_Value.ADMIN_ORDER_HANDLE_URL, Constants_Value.ADMIN_ORDER_MANAGER_URL,
		Constants_Value.ADMIN_ORDER_SEARCH_URL})
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
		case Constants_Value.ADMIN_ORDER_MANAGER_URL:
			request.setAttribute("orderList", OrderDAO.getAll());
			request.setAttribute("orderStatus", OrderStatusDAO.getAll());
			request.getRequestDispatcher(Constants_Value.FILE_ADMIN_ORDER_MANAGER_URL).forward(request, response);
			break;
		case Constants_Value.ADMIN_ORDER_HANDLE_URL:
			request.setAttribute("productList", ProductDAO.getAllByOrderId(Integer.parseInt(request.getParameter("id"))));
			request.setAttribute("orderStatusList", OrderStatusDAO.getAll());
			request.setAttribute("order", OrderDAO.getById(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher(Constants_Value.FILE_ADMIN_ORDER_UPDATE_URL).forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getServletPath();

		int orderStatusId = 0;
		Date deliveredDate;
		int id = -1;
		

		switch (action)
		{
		case Constants_Value.ADMIN_ORDER_HANDLE_URL:
			deliveredDate = Date.valueOf(request.getParameter("deliveredDate"));
			orderStatusId = Integer.parseInt(request.getParameter("orderStatusId"));
			id = Integer.parseInt(request.getParameter("id"));
			OrderDAO.update(deliveredDate, orderStatusId, id);
			response.sendRedirect(request.getContextPath() + Constants_Value.ADMIN_ORDER_MANAGER_URL);
			break;
		case Constants_Value.ADMIN_ORDER_SEARCH_URL:
			doPost_SearchOrder(request, response);
			break;
		}
	}

	protected void doPost_SearchOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String searchCondition = "WHERE";
		ArrayList<String> searchParameter = new ArrayList<String>();
		String searchParameterTemp = "";

		int id = -1;
		String customer_name = "&";
		String phone = "&";
		String email = "&";
		Date order_date = null;
		int order_status_id = -1;
		
		// add search parameter into one list
		if (request.getParameter("id") != "")
		{
			id = Integer.parseInt(request.getParameter("id"));
			searchParameterTemp = "order_id = " + id;
			searchParameter.add(searchParameterTemp);
		}
		if (request.getParameter("customer_name") != "")
		{
			customer_name = request.getParameter("customer_name");
			searchParameterTemp = "UPPER(customer.name) LIKE UPPER('%" + customer_name + "%')";
			searchParameter.add(searchParameterTemp);
		}
		if (request.getParameter("phone") != "")
		{
			phone = request.getParameter("phone");
			searchParameterTemp = "phone LIKE '" + phone + "'";
			searchParameter.add(searchParameterTemp);
		}
		if (request.getParameter("email") != "")
		{
			email = request.getParameter("email");
			searchParameterTemp = "email LIKE '%" + email + "%'";
			searchParameter.add(searchParameterTemp);
		}
		if (request.getParameter("order_date") != "")
		{
			order_date = Date.valueOf(request.getParameter("order_date"));
			searchParameterTemp = "cuahanganvat.order.order_date >= '" + order_date + "'";
			searchParameter.add(searchParameterTemp);
		}
		if (request.getParameter("order_status_id") != "")
		{
			order_status_id = Integer.parseInt(request.getParameter("order_status_id"));
			searchParameterTemp = "order_status.id = " + order_status_id;
			searchParameter.add(searchParameterTemp);
		}
		// assembling the search condition
		if (searchParameter.size() > 0)
		{
			for (int i = 0; i < searchParameter.size(); i++)
			{
				if (i == 0)
					searchCondition += " " + searchParameter.get(i);
				else
					searchCondition += " AND " + searchParameter.get(i);
			}
		}
		else
			searchCondition = "";

		request.setAttribute("orderList", OrderDAO.search(searchCondition));
		request.setAttribute("orderStatus", OrderStatusDAO.getAll());
		request.getRequestDispatcher(Constants_Value.FILE_ADMIN_ORDER_MANAGER_URL).forward(request, response);
	}
}
