package com.omatechnology.servlets;

import com.omatechnology.dataaccess.UserDAOImpl;
import com.omatechnology.dataaccess.UserDAOInterface;
import com.omatechnology.entities.User;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAOInterface userDAO = new UserDAOImpl();

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");

        String encodedPass = new String(new Base64().encode(pass.getBytes()));
        User user = new User(username, encodedPass, email, gender);
        userDAO.insert(user);
        response.sendRedirect("login.jsp");
    }
}
