package com.Servlet;

import com.DAOImpl.DaoImpl;
import com.Model.EmployeeDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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