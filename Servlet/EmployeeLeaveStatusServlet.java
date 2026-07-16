package com.Servlet;

import java.io.IOException;
import java.util.List;

import com.DAOImpl.DaoImpl;
import com.Model.LeaveRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/EmployeeLeaveStatusServlet")
public class EmployeeLeaveStatusServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        int empId = (int) session.getAttribute("employeeID");

        DaoImpl dao = new DaoImpl();
        List<LeaveRequest> list = dao.getLeaveByEmployee(empId);

        request.setAttribute("leaveList", list);
        request.getRequestDispatcher("employeeLeaveStatus.jsp").forward(request, response);
    }
}
