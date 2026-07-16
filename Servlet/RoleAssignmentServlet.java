package com.Servlet;

import java.io.IOException;

import com.DAOImpl.DaoImpl;
import com.Model.EmployeeDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RoleAssignmentServlet")
public class RoleAssignmentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        EmployeeDetails emp = new EmployeeDetails();

        // Getting values from role assignment form
        emp.setEmployeeID(Integer.parseInt(req.getParameter("employeeID")));
        emp.setRole(req.getParameter("role"));
        emp.setDepartment(req.getParameter("department"));

        // DAO call (timestamp handled in DB)
        new DaoImpl().assignRole(emp);

        // Redirect back to role assignment list
        res.sendRedirect("RoleAssignmentListServlet");
    }
}
