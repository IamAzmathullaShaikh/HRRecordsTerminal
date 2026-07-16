
package com.Servlet;

import com.DAOImpl.DaoImpl;
import com.Model.EmployeeDetails;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EmployeeDetails e = new EmployeeDetails();
        e.setEmployeeName(request.getParameter("employeeName"));
        e.setGender(request.getParameter("gender"));
        e.setDob(request.getParameter("dob"));
        e.setEmail(request.getParameter("email"));
        e.setPhoneNo(request.getParameter("phoneNo"));
        e.setRole(request.getParameter("role"));
        e.setDepartment(request.getParameter("department"));
        e.setSalary(Double.parseDouble(request.getParameter("salary")));
        
        DaoImpl daoImpl = new DaoImpl();
        boolean success = daoImpl.addEmployee(e);
        System.out.println(success);
        if(success) {
            response.sendRedirect("EmployeeListServlet");
        } else {
            response.sendRedirect("addEmployee.jsp?msg=error");
        }
    }
}