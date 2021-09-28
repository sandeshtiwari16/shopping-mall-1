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

import entities.Customer;
import repository.CustomerDao;



@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao;
	
	public void init() {
		customerDao = new CustomerDao();
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
				insertCustomer(request, response);
				break;
			case "delete":
				deleteCustomer(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateCustomer(request, response);
				break;
			case "list":
				listCustomer(request, response);
				break;
			default:
				listCustomer(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Customer> listCustomer = customerDao.getAllCustomer();
		request.setAttribute("listCustomer", listCustomer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerDisplay.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerIndex.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Customer existingCustomer = customerDao.getCustomer(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerIndex.jsp");
		request.setAttribute("customer", existingCustomer);
		dispatcher.forward(request, response);

	}

	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String roll = request.getParameter("roll");
		String qualification = request.getParameter("qualification");
		String course = request.getParameter("course");

		Customer newCustomer = new Customer(name, college, roll, qualification, course);
		customerDao.saveCustomer(newCustomer);
		response.sendRedirect("customer?action=list");
	}

	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String roll = request.getParameter("roll");
		String qualification = request.getParameter("qualification");
		String course = request.getParameter("course");

		Customer customer = new Customer(id, name, college, roll, qualification, course);
		customerDao.updateCustomer(customer);
		response.sendRedirect("customer?action=list");
	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		customerDao.deleteCustomer(id);
		response.sendRedirect("customer?action=list");
	}
}
