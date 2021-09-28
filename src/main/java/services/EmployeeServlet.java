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

import entities.Employee;
import repository.EmployeeDao;



@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao;
	
	public void init() {
		employeeDao = new EmployeeDao();
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
				insertEmployee(request, response);
				break;
			case "delete":
				deleteEmployee(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateEmployee(request, response);
				break;
			case "list":
				listEmployee(request, response);
				break;
			default:
				listEmployee(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Employee> listEmployee = employeeDao.getAllEmployee();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeDisplay.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeIndex.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existingEmployee = employeeDao.getEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employeeIndex.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);

	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String roll = request.getParameter("roll");
		String qualification = request.getParameter("qualification");
		String course = request.getParameter("course");
		String year = request.getParameter("year");

		Employee newEmployee = new Employee(name, college, roll, qualification, course, year);
		employeeDao.saveEmployee(newEmployee);
		response.sendRedirect("employee?action=list");
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String roll = request.getParameter("roll");
		String qualification = request.getParameter("qualification");
		String course = request.getParameter("course");
		String year = request.getParameter("year");

		

		Employee employee = new Employee(id, name, college, roll, qualification, course, year);
		employeeDao.updateEmployee(employee);
		response.sendRedirect("employee?action=list");
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeDao.deleteEmployee(id);
		response.sendRedirect("employee?action=list");
	}
}
