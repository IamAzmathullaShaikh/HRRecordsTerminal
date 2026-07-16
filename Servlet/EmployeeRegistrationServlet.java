package com.Servlet;

import java.io.IOException;

import com.Model.EmployeeModel;
import com.DAOImpl.DaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeRegistrationServlet")
public class EmployeeRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create EmployeeRegister object and set values from form
        EmployeeModel employee = new EmployeeModel();
        employee.setFirstName(request.getParameter("firstName"));
        employee.setLastName(request.getParameter("lastName"));
        employee.setGender(request.getParameter("gender"));
        employee.setDob(request.getParameter("dob"));  // yyyy-MM-dd
        employee.setMaritalStatus(request.getParameter("maritalStatus"));
        employee.setCountry(request.getParameter("country"));
        employee.setPhno(request.getParameter("phno"));
        employee.setEmail(request.getParameter("email"));
        employee.setPassword(request.getParameter("password"));

        // Call DAO to register employee
        DaoImpl dao = new DaoImpl();
        boolean result = dao.registerEmployee(employee);
        if (result) {
            // Redirect to employee login page after successful registration
            response.sendRedirect("EmployeeLogin.jsp");
        } else {
            response.sendRedirect("EmployeeLogin.jsp");
        }
    }
}
