package services;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.UserDao;
import entities.User;

@WebServlet("/register")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String password = request.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setType(type);
        user.setPassword(password);

        userDao.saveUser(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
        dispatcher.forward(request, response);
    }
}
