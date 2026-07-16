package com.Servlet;

import java.io.IOException;
import com.DAOImpl.DaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        DaoImpl dao = new DaoImpl();
        boolean status = dao.loginUser(email, password);

        if (status) {
            response.sendRedirect("HRdashboard.html");
        } else {
        	
        	response.sendRedirect("login.html");
        }
    }
}