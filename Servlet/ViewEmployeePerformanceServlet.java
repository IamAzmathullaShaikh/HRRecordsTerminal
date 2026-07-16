package com.Servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.DAOImpl.DaoImpl;
import com.Model.EmployeeDetails;
import com.Model.EmployeePerformance;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ViewEmployeePerformanceServlet")
public class ViewEmployeePerformanceServlet extends HttpServlet {

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

        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int year = today.getYear();

        DaoImpl dao = new DaoImpl();
        EmployeePerformance perf =
                dao.calculatePerformance(empId, month, year);

        List<EmployeePerformance> list = new ArrayList<>();
        if (perf != null) list.add(perf);

        req.setAttribute("performanceList", list);
        req.getRequestDispatcher("/PerformanceReport.jsp")
           .forward(req, resp);
    }
}
