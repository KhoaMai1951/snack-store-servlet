package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.sun.corba.se.pept.transport.ContactInfo;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import dao.CategoryDAO;
import dao.ProductDAO;
import entities.Cart;
import entities.Category;
import entities.Product;
import ultilities.Constants_Value;
import ultilities.FileHandler;

/**
 * Servlet implementation class View_ProductManagementController
 */
@WebServlet(urlPatterns =
{ Constants_Value.ADMIN_PRODUCT_MANAGER_URL, Constants_Value.ADMIN_PRODUCT_EDIT_URL,
		Constants_Value.ADMIN_PRODUCT_DELETE_URL, Constants_Value.ADMIN_PRODUCT_UPLOAD_URL,
		Constants_Value.ADMIN_PRODUCT_DELETED_PRODUCT_URL, Constants_Value.ADMIN_PRODUCT_RESTORE_URL,
		Constants_Value.ADMIN_LOGOUT_URL})
@MultipartConfig
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
		case Constants_Value.ADMIN_PRODUCT_MANAGER_URL:
			request.setAttribute("categoryList", CategoryDAO.getAll());
			request.setAttribute("productList", ProductDAO.getAll());
			// get session
			if (request.getSession().getAttribute("cart") != null)
			{
				Cart cart = (Cart) request.getSession().getAttribute("cart");
				request.setAttribute("items", cart.getItems());
				request.setAttribute("sumPrice", cart.getSumPrice());
			}
			request.getRequestDispatcher(Constants_Value.FILE_ADMIN_PRODUCT_MANAGER_URL).forward(request, response);
			break;
		case Constants_Value.ADMIN_PRODUCT_EDIT_URL:
			Product product = ProductDAO.getProduct(request.getParameter("product_id"));
			ArrayList<Category> categoryList = CategoryDAO.getAll();
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("product", product);
			request.getRequestDispatcher(Constants_Value.FILE_ADMIN_PRODUCT_EDIT_URL).forward(request, response);
			break;
		case Constants_Value.ADMIN_PRODUCT_DELETE_URL:
			ProductDAO.delete(request.getParameter("productID"));
			response.sendRedirect(request.getContextPath() + Constants_Value.ADMIN_PRODUCT_MANAGER_URL);
			break;
		case Constants_Value.ADMIN_PRODUCT_UPLOAD_URL:
			request.setAttribute("categoryList", CategoryDAO.getAll());
			request.getRequestDispatcher(Constants_Value.FILE_ADMIN_PRODUCT_UPLOAD_URL).forward(request, response);
			break;
		case Constants_Value.ADMIN_LOGOUT_URL:
			HttpSession session = request.getSession();
			session.removeAttribute(Constants_Value.IS_ADMIN_LOGIN);
			response.sendRedirect(request.getContextPath() + Constants_Value.LOGIN_URL);
			break;
		case Constants_Value.ADMIN_PRODUCT_DELETED_PRODUCT_URL:
			request.setAttribute("categoryList", CategoryDAO.getAll());
			request.setAttribute("productList", ProductDAO.getAllDeleted());
			request.getRequestDispatcher(Constants_Value.FILE_ADMIN_PRODUCT_DELETED_PRODUCT_URL).forward(request, response);
			break;
		case Constants_Value.ADMIN_PRODUCT_RESTORE_URL:
			ProductDAO.restoreDeletedProductById(Integer.parseInt((String) request.getParameter("productID")));
			response.sendRedirect(request.getContextPath() + Constants_Value.ADMIN_PRODUCT_DELETED_PRODUCT_URL);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getServletPath();
		switch (action)
		{
		case Constants_Value.ADMIN_PRODUCT_EDIT_URL:
			doPost_EditProduct(request, response);
			response.sendRedirect(request.getContextPath() + Constants_Value.ADMIN_PRODUCT_MANAGER_URL);
			break;
		case Constants_Value.ADMIN_PRODUCT_UPLOAD_URL:
			doPost_UploadProduct(request, response);
			response.sendRedirect(request.getContextPath() + Constants_Value.ADMIN_PRODUCT_DELETED_PRODUCT_URL);
			break;
		}
	}

	protected void doPost_EditProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// get resources folder directory
		String resourcesPath = getServletContext().getRealPath("/") + "resources";

		FileHandler fl = new FileHandler();

		String name = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		int category_id = Integer.parseInt(request.getParameter("category"));
		String description = request.getParameter("description");
		String img_name;
		int product_id = Integer.parseInt(request.getParameter("product_id"));

		// if don't change product image
		Part filePart = request.getPart("image");
		if (filePart.getSize() == 0)
		{
			img_name = request.getParameter("img_name");

			ProductDAO.updateProduct(category_id, name, quantity, description, price, img_name, product_id);
		}
		// change product image too
		else
		{
			fl.imageUpload(request, resourcesPath);
			img_name = fl.fileName;
			ProductDAO.updateProduct(category_id, name, quantity, description, price, img_name, product_id);
		}
	}

	protected void doPost_UploadProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		FileHandler fl = new FileHandler();
		String resourcesPath = getServletContext().getRealPath("/") + "resources";

		String name = request.getParameter("name");
		String img_name;
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		int category_id = Integer.parseInt(request.getParameter("categories"));
		String description = request.getParameter("description");

		Part filePart = request.getPart("image");
		// if don't upload image
		if (filePart != null)
		{
			fl.imageUpload(request, resourcesPath);
			img_name = fl.fileName;
			ProductDAO.add(category_id, name, quantity, img_name, description, price);
		}
		else
		{
			img_name = "";
			ProductDAO.add(category_id, name, quantity, img_name, description, price);
		}
	}
}
