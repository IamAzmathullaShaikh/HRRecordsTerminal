package com.Servlet;

import java.io.IOException;
import com.Model.EmployeeDetails;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ManagerDashboardServlet")
public class ManagerDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1️⃣ Get existing session (do NOT create a new one)
        HttpSession session = req.getSession(false);

        // 2️⃣ Initialize manager variable
        EmployeeDetails manager = null;

        // 3️⃣ Only try to get attribute if session exists
        if (session != null) {
            Object empObj = session.getAttribute("employee");
            if (empObj instanceof EmployeeDetails) {
                manager = (EmployeeDetails) empObj;
            }
        }

        // 4️⃣ Check if manager is null or role is not "Manager"
        if (manager == null || !"Manager".equalsIgnoreCase(manager.getRole())) {
            resp.sendRedirect(req.getContextPath() + "/ManagerLogin.jsp?error=invalid");
            return;
        }

        // 5️⃣ Forward to dashboard JSP
        req.setAttribute("managerName", manager.getEmployeeName()); // optional for display
        req.getRequestDispatcher("ManagerDashboard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp); // Support POST requests the same way
    }
}
