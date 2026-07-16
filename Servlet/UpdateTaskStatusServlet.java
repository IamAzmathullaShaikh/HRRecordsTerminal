package com.Servlet;

import java.io.IOException;

import com.DAOImpl.DaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateTaskStatusServlet")
public class UpdateTaskStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int taskId = Integer.parseInt(req.getParameter("taskId"));

        DaoImpl dao = new DaoImpl();
        dao.updateTaskStatus(
            taskId,
            "COMPLETED",
            java.time.LocalDate.now().toString()
        );

        resp.sendRedirect("EmployeeTasks.jsp");
    }
}
