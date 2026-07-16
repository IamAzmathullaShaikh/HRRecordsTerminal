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

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        EmployeeDetails emp = new EmployeeDetails();

        emp.setEmployeeID(Integer.parseInt(req.getParameter("employeeID")));
        emp.setEmployeeName(req.getParameter("employeeName"));
        emp.setGender(req.getParameter("gender"));
        emp.setDob(req.getParameter("dob"));
        emp.setEmail(req.getParameter("email"));
        emp.setPhoneNo(req.getParameter("phoneNo"));
        emp.setRole(req.getParameter("role"));
        emp.setDepartment(req.getParameter("department"));
        emp.setSalary(Double.parseDouble(req.getParameter("salary")));

       new DaoImpl().updateEmployee(emp);
       res.sendRedirect("EmployeeListServlet");
    }
}
