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

@WebServlet("/getEmployee")
public class GetEmployeeByIdServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("employeeID"));

        Dao dao = new DaoImpl();
        EmployeeDetails emp = dao.getEmployeeById(id);

        req.setAttribute("employee", emp);
        req.getRequestDispatcher("updateEmployee.jsp")
           .forward(req, res);
    }
}



