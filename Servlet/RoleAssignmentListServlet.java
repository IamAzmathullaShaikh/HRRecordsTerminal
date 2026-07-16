package com.Servlet;

import com.DAO.Dao;
import com.DAOImpl.DaoImpl;
import com.Model.EmployeeDetails;
import com.Model.RoleAssignment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RoleAssignmentListServlet")
public class RoleAssignmentListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // DAO instance
        Dao dao = new DaoImpl();
        System.out.println("hello");
        // Fetch all employees with their roles and departments
        List<RoleAssignment> roleList = dao.getAllRoleAssignments(); // You need to implement this in your DAO
        System.out.println(roleList);
        // Set as request attribute for JSP
        request.setAttribute("RoleAssignmentList", roleList);

        // Forward to JSP page to display role assignments
        request.getRequestDispatcher("RoleAssignmentTable.jsp").forward(request, response);
    }
}
