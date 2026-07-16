package com.Servlet;

import java.io.IOException;
import java.sql.Date;

import com.DAOImpl.DaoImpl;
import com.Model.LeaveRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
