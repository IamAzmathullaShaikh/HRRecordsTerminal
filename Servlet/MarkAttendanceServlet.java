package com.Servlet;

import java.io.IOException;
import java.time.LocalDate;

import com.DAO.Dao;
import com.DAOImpl.DaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MarkAttendanceServlet")
public class MarkAttendanceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // Check if employee is logged in
        if (session == null || session.getAttribute("employeeID") == null) {
            response.sendRedirect("EmployeeLogin.jsp");
            return;
        }

        int employeeID = (int) session.getAttribute("employeeID");
        LocalDate today = LocalDate.now();

        Dao dao = new DaoImpl();

        boolean alreadyMarked = dao.isAttendanceMarked(employeeID, today);
        if (!alreadyMarked) {
            boolean success = dao.markAttendance(employeeID, today, "PRESENT");

            if (success) {
                session.setAttribute("msg", "Attendance marked successfully for today!");
            } else {
                session.setAttribute("msg", "Failed to mark attendance. Try again.");
            }
        } else {
            session.setAttribute("msg", "You have already marked your attendance today.");
        }

        response.sendRedirect("employeedashboard.jsp");
    }
}
