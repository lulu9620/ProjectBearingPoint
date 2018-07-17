package com.omatechnology.servlets;

import com.omatechnology.dataaccess.ProjectDAOImpl;
import com.omatechnology.dataaccess.ProjectDAOInterface;
import com.omatechnology.entities.Project;
import com.omatechnology.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class HomeServlet extends HttpServlet {
    ProjectDAOInterface projectDAO = new ProjectDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession(false).getAttribute("user");
        if (user != null) {
            List<Project> projectList = projectDAO.getProjectsByUsername(user.getUsername());
            request.setAttribute("projectList", projectList);
            request.getRequestDispatcher("/index.jsp").
                    forward(request, response);
            return;
        } else {
            response.sendRedirect("/login.jsp");
        }
    }
}
