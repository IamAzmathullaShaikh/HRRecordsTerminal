package com.Servlet;

import java.io.IOException;
import java.util.List;

import com.DAOImpl.DaoImpl;
import com.Model.EmployeeDetails;
import com.Model.ProjectTask;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/EmployeeTasksServlet")
public class EmployeeTasksServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("employee") == null) {
            resp.sendRedirect(req.getContextPath() + "/EmployeeLogin.jsp");
            return;
        }

        EmployeeDetails emp =
            (EmployeeDetails) session.getAttribute("employee");

        int empId = emp.getEmployeeID();

        DaoImpl dao = new DaoImpl();
        List<ProjectTask> taskList = dao.getTasksByEmployeeId(empId);

        req.setAttribute("taskList", taskList);
        req.getRequestDispatcher("/EmployeeTasks.jsp")
           .forward(req, resp);
    }
}
