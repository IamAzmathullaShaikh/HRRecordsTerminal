package com.Servlet;

import java.io.IOException;
import java.util.List;

import com.DAOImpl.DaoImpl;
import com.Model.LeaveRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
