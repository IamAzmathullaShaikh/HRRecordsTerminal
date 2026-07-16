package com.Servlet;

import java.io.IOException;

import com.DAOImpl.DaoImpl;
import com.Model.AttendanceSummary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
