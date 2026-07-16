package com.Servlet;

import java.io.IOException;

import com.DAOImpl.DaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String empIdStr = req.getParameter("employeeID");
        System.out.println("Received employeeID = " + empIdStr);

        if (empIdStr == null || empIdStr.isEmpty()) {
            System.out.println("ERROR: employeeID is null or empty");
            res.sendRedirect("EmployeeListServlet");
            return;
        }

        int id = Integer.parseInt(empIdStr);

        DaoImpl dao = new DaoImpl();
        boolean deleted = dao.deleteEmployee(id);

        System.out.println("Deleted employee ID = " + id);
        System.out.println("Delete success = " + deleted);

        res.sendRedirect("EmployeeListServlet");
    }
}
