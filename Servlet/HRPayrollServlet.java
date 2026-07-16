package com.Servlet;

import java.io.IOException;
import java.util.List;

import com.DAOImpl.DaoImpl;
import com.Model.PayrollDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HRPayrollServlet")
public class HRPayrollServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        DaoImpl dao = new DaoImpl();
        List<PayrollDetails> payrollList = dao.getAllPayroll();

        req.setAttribute("payrollList", payrollList);
        req.getRequestDispatcher("HRPayroll.jsp").forward(req, resp);
    }
}
