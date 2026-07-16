package com.Servlet;

import com.DAOImpl.DaoImpl;
import com.Model.EmployeeDetails;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.List;
import com.DAO.Dao;

@WebServlet("/EmployeeListServlet")
public class EmployeeListServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Dao dao = new DaoImpl();
        List<EmployeeDetails> list = dao.getAllEmployees();
        
        request.setAttribute("EmployeeList", dao.getAllEmployees()); // JSP ki forward cheyyadaniki
        request.getRequestDispatcher("EmployeeList.jsp").forward(request, response);
        
    }
}