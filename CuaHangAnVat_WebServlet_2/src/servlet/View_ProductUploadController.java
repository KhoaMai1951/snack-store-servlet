package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.CategoryDAO;
import dao.ProductDAO;
import ultilities.FileHandler;

/**
 * Servlet implementation class View_ProductAddController
 */
@WebServlet("/View_ProductUploadController")
@MultipartConfig
public class View_ProductUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public View_ProductUploadController() {
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

		request.setAttribute("categoryList", CategoryDAO.getAll());

		request.getRequestDispatcher("/pages/productUpload.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		if (filePart != null) {
			fl.imageUpload(request, resourcesPath);
			img_name = fl.fileName;
			ProductDAO.add(category_id, name, quantity, img_name, description, price);
		} else {
			img_name = "";
			ProductDAO.add(category_id, name, quantity, img_name, description, price);
		}
	}
}
