package com.Servlet;

import java.io.IOException;

import com.DAO.Dao;
import com.DAOImpl.DaoImpl;
import com.Model.EmployeeDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EmployeeDetailsServlet")
public class EmployeeDetailsServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("employeeID") == null) {
            response.sendRedirect("EmployeeLogin.jsp");
            return;
        }

     

        int empId = (int) session.getAttribute("employeeID");

        Dao dao = new DaoImpl();
        EmployeeDetails emp = dao.getEmployeeById(empId);

        request.setAttribute("emp", emp);
        request.getRequestDispatcher("EmployeeDetails.jsp").forward(request, response);
    }
}
