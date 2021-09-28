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

import entities.Owner;
import repository.OwnerDao;



@WebServlet("/owner")
public class OwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OwnerDao ownerDao;
	
	public void init() {
		ownerDao = new OwnerDao();
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
				insertOwner(request, response);
				break;
			case "delete":
				deleteOwner(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateOwner(request, response);
				break;
			case "list":
				listOwner(request, response);
				break;
			default:
				listOwner(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listOwner(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Owner> listOwner = ownerDao.getAllOwner();
		request.setAttribute("listOwner", listOwner);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ownerDisplay.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ownerIndex.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Owner existingOwner = ownerDao.getOwner(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ownerIndex.jsp");
		request.setAttribute("owner", existingOwner);
		dispatcher.forward(request, response);

	}

	private void insertOwner(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String roll = request.getParameter("roll");
		String qualification = request.getParameter("qualification");

		Owner newOwner = new Owner(name, college, roll, qualification);
		ownerDao.saveOwner(newOwner);
		response.sendRedirect("owner?action=list");
	}

	private void updateOwner(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String roll = request.getParameter("roll");
		String qualification = request.getParameter("qualification");

		Owner owner = new Owner(id, name, college, roll, qualification);
		ownerDao.updateOwner(owner);
		response.sendRedirect("owner?action=list");
	}

	private void deleteOwner(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ownerDao.deleteOwner(id);
		response.sendRedirect("owner?action=list");
	}
}
