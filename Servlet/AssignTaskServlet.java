package com.Servlet;

import java.io.IOException;

import com.DAOImpl.DaoImpl;
import com.Model.ProjectTask;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AssignTaskServlet")
public class AssignTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProjectTask task = new ProjectTask();
        task.setEmployeeID(Integer.parseInt(req.getParameter("employeeID")));
        task.setTaskName(req.getParameter("taskName"));
        task.setDescription(req.getParameter("description"));
        task.setStartDate(req.getParameter("startDate"));
        task.setDueDate(req.getParameter("dueDate"));
        task.setStatus("ASSIGNED");

        DaoImpl dao = new DaoImpl();
        dao.assignTask(task);

        resp.sendRedirect("ManagerDashboard.jsp");
    }
}
