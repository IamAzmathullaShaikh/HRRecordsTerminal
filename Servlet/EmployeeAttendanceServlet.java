package com.Servlet;

import java.io.IOException;

import com.DAOImpl.DaoImpl;
import com.Model.AttendanceSummary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/EmployeeAttendanceServlet")
public class EmployeeAttendanceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("employeeID") == null) {
            response.sendRedirect("EmployeeLogin.jsp");
            return;
        }

        int empID = (int) session.getAttribute("employeeID");
        DaoImpl dao = new DaoImpl();
        AttendanceSummary summary = dao.getAttendanceByEmployee(empID);

        request.setAttribute("summary", summary);
        request.getRequestDispatcher("employeeAttendance.jsp").forward(request, response);
    }
}
