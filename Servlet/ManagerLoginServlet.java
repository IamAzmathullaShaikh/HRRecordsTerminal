package com.Servlet;

import java.io.IOException;
import com.DAOImpl.DaoImpl;
import com.Model.EmployeeDetails;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        DaoImpl dao = new DaoImpl();
        EmployeeDetails manager = dao.getManagerByEmailAndPassword(email, password);

        if (manager != null) {
            // Store manager in session
            HttpSession session = request.getSession();
            session.setAttribute("employee", manager);

            // Redirect to dashboard
            response.sendRedirect(request.getContextPath() + "/ManagerDashboardServlet");
        } else {
            // Login failed
            response.sendRedirect("ManagerLogin.jsp?error=invalid");
        }
    }
}
