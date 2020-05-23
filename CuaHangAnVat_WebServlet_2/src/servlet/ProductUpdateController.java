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

import dao.ProductDAO;
import ultilities.FileHandler;

/**
 * Servlet implementation class ProductUpdateController
 */
@WebServlet("/ProductUpdateController")
@MultipartConfig
public class ProductUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductUpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/CuaHangAnVat_WebServlet_2/View_ProductManagementController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get resources folder directory
		String resourcesPath = getServletContext().getRealPath("/") + "resources";
		System.out.println(resourcesPath);

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
		if (filePart.getSize() == 0) {
			img_name = request.getParameter("img_name");

			ProductDAO.updateProduct(category_id, name, quantity, description, price, img_name, product_id);

		}
		// change product image too
		else {
			fl.imageUpload(request, resourcesPath);
			img_name = fl.fileName;

			ProductDAO.updateProduct(category_id, name, quantity, description, price, img_name, product_id);
		}

		// redirect after finished
		response.sendRedirect("/CuaHangAnVat_WebServlet_2/View_ProductManagementController");
	}

}
