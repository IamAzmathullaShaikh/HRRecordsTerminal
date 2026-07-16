package com.Servlet;

import java.io.IOException;

import com.DAOImpl.DaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
