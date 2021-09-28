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

import entities.Mall;
import repository.MallDao;



@WebServlet("/mall")
public class MallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MallDao mallDao;
	
	public void init() {
		mallDao = new MallDao();
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
				insertMall(request, response);
				break;
			case "delete":
				deleteMall(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateMall(request, response);
				break;
			case "list":
				listMall(request, response);
				break;
			default:
				listMall(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listMall(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Mall> listMall = mallDao.getAllMall();
		request.setAttribute("listMall", listMall);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mallDisplay.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("mallIndex.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Mall existingMall = mallDao.getMall(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mallIndex.jsp");
		request.setAttribute("mall", existingMall);
		dispatcher.forward(request, response);

	}

	private void insertMall(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String roll = request.getParameter("roll");
		String qualification = request.getParameter("qualification");

		Mall newMall = new Mall(name, college, roll, qualification);
		mallDao.saveMall(newMall);
		response.sendRedirect("mall?action=list");
	}

	private void updateMall(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String roll = request.getParameter("roll");
		String qualification = request.getParameter("qualification");

		Mall mall = new Mall(id, name, college, roll, qualification);
		mallDao.updateMall(mall);
		response.sendRedirect("mall?action=list");
	}

	private void deleteMall(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		mallDao.deleteMall(id);
		response.sendRedirect("mall?action=list");
	}
}
