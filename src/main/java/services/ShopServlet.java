package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Shop;
import repository.ShopDao;



@WebServlet("/shop")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopDao shopDao;
	
	public void init() {
		shopDao = new ShopDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insertShop(request, response);
				break;
			case "delete":
				deleteShop(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateShop(request, response);
				break;
			case "list":
				listShop(request, response);
				break;
			default:
				listShop(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listShop(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Shop> listShop = shopDao.getAllShop();
		request.setAttribute("listShop", listShop);
		RequestDispatcher dispatcher = request.getRequestDispatcher("shopDisplay.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("shopIndex.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Shop existingShop = shopDao.getShop(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("shopIndex.jsp");
		request.setAttribute("shop", existingShop);
		dispatcher.forward(request, response);

	}

	private void insertShop(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String roll = request.getParameter("roll");
		String qualification = request.getParameter("qualification");
		String course = request.getParameter("course");

		Shop newShop = new Shop(name, college, roll, qualification, course);
		shopDao.saveShop(newShop);
		response.sendRedirect("shop?action=list");
	}

	private void updateShop(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String roll = request.getParameter("roll");
		String qualification = request.getParameter("qualification");
		String course = request.getParameter("course");

		Shop shop = new Shop(id, name, college, roll, qualification, course);
		shopDao.updateShop(shop);
		response.sendRedirect("shop?action=list");
	}

	private void deleteShop(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		shopDao.deleteShop(id);
		response.sendRedirect("shop?action=list");
	}
}
