package com.Servlet;

import java.io.IOException;

import com.DAO.Dao;
import com.DAOImpl.DaoImpl;
import com.Model.EmployeeDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EmployeeLoginServlet")
public class EmployeeLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int employeeID = Integer.parseInt(request.getParameter("employeeID"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Dao dao = new DaoImpl();
        EmployeeDetails emp = dao.loginEmployee(employeeID, email, password);

        if (emp != null) {

            HttpSession session = request.getSession(true);

            // ✅ STORE FULL OBJECT (VERY IMPORTANT)
            session.setAttribute("employee", emp);

            // optional
            session.setAttribute("employeeID", emp.getEmployeeID());
            session.setAttribute("employeeName", emp.getEmployeeName());

            response.sendRedirect(request.getContextPath() + "/employeedashboard.jsp");

        } else {
            request.setAttribute("error", "Invalid login");
            request.getRequestDispatcher("EmployeeLogin.jsp")
                   .forward(request, response);
        }
    }
}
