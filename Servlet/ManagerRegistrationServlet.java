package com.Servlet;


import java.io.IOException;

import com.Model.ManagerModel;
import com.DAOImpl.DaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ManagerRegistrationServlet")
public class ManagerRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create ManagerRegister object and set values from form
        ManagerModel manager = new ManagerModel();
        manager.setFirstName(request.getParameter("firstName"));
        manager.setLastName(request.getParameter("lastName"));
        manager.setGender(request.getParameter("gender"));
        manager.setDob(request.getParameter("dob"));  // yyyy-MM-dd
        manager.setMaritalStatus(request.getParameter("maritalStatus"));
        manager.setCountry(request.getParameter("country"));
        manager.setPhno(request.getParameter("phno"));
        manager.setEmail(request.getParameter("email"));
        manager.setPassword(request.getParameter("password"));
        manager.setDepartment(request.getParameter("department"));
        // Call DAO to register manager
        DaoImpl dao = new DaoImpl();
        boolean result = dao.registerManager(manager);

        if (result) {
            // Redirect to manager login page after successful registration
        	 response.getWriter().println("Manager registration failed!");
        } else {
           
            response.sendRedirect("ManagerLogin.jsp");
        }
    }
}