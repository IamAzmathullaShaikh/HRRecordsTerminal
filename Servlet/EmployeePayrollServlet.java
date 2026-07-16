
package com.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

import com.DAOImpl.DaoImpl;
import com.Model.PayrollDetails;
import com.Model.EmployeeDetails;

@WebServlet("/EmployeePayrollServlet")
public class EmployeePayrollServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        EmployeeDetails emp = (EmployeeDetails) session.getAttribute("employee");

        if (emp == null) {
            resp.sendRedirect("EmployeeLogin.jsp");
            return;
        }

        DaoImpl dao = new DaoImpl();
        List<PayrollDetails> list = dao.getPayrollByEmployee(emp.getEmployeeID());

        req.setAttribute("payrollList", list);
        req.getRequestDispatcher("EmployeePayroll.jsp").forward(req, resp);
    }
}
