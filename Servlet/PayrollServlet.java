
package com.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

import com.DAOImpl.DaoImpl;
import com.Model.PayrollDetails;

@WebServlet("/PayrollServlet")
public class PayrollServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int employeeID = Integer.parseInt(req.getParameter("employeeID"));
        int month = Integer.parseInt(req.getParameter("month"));
        int year = Integer.parseInt(req.getParameter("year"));

        DaoImpl dao = new DaoImpl();

        PayrollDetails payroll = dao.calculatePayroll(employeeID, month, year);

        if (payroll != null) {
            dao.savePayroll(payroll);
            req.setAttribute("payroll", payroll);
            req.getRequestDispatcher("PayrollResult.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("PayrollManagement.jsp?error=true");
        }
    }
}
