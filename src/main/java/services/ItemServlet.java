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

import entities.Item;
import repository.ItemDao;



@WebServlet("/item")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemDao itemDao;
	
	public void init() {
		itemDao = new ItemDao();
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
				insertItem(request, response);
				break;
			case "delete":
				deleteItem(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateItem(request, response);
				break;
			case "list":
				listItem(request, response);
				break;
			default:
				listItem(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listItem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Item> listItem = itemDao.getAllItem();
		request.setAttribute("listItem", listItem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("itemDisplay.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("itemIndex.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Item existingItem = itemDao.getItem(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("itemIndex.jsp");
		request.setAttribute("item", existingItem);
		dispatcher.forward(request, response);

	}

	private void insertItem(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String roll = request.getParameter("roll");
		String qualification = request.getParameter("qualification");
		String course = request.getParameter("course");

		Item newItem = new Item(name, college, roll, qualification, course);
		itemDao.saveItem(newItem);
		response.sendRedirect("item?action=list");
	}

	private void updateItem(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String roll = request.getParameter("roll");
		String qualification = request.getParameter("qualification");
		String course = request.getParameter("course");

		Item item = new Item(id, name, college, roll, qualification, course);
		itemDao.updateItem(item);
		response.sendRedirect("item?action=list");
	}

	private void deleteItem(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		itemDao.deleteItem(id);
		response.sendRedirect("item?action=list");
	}
}
