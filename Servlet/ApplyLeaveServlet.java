package com.Servlet;

import java.io.IOException;
import java.sql.Date;

import com.DAOImpl.DaoImpl;
import com.Model.LeaveRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ApplyLeaveServlet")
public class ApplyLeaveServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("employeeID") == null) {
            response.sendRedirect("EmployeeLogin.jsp");
            return;
        }

        int empId = (int) session.getAttribute("employeeID");

        LeaveRequest leave = new LeaveRequest();
        leave.setEmployeeID(empId);
        leave.setFromDate(Date.valueOf(request.getParameter("fromDate")));
        leave.setToDate(Date.valueOf(request.getParameter("toDate")));
        leave.setReason(request.getParameter("reason"));

        DaoImpl dao = new DaoImpl();
        dao.applyLeave(leave);

        response.sendRedirect("employeedashboard.jsp");
    }
}
