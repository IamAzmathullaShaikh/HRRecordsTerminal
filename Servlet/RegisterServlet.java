package com.Servlet;

import java.io.IOException;

import com.DAOImpl.DaoImpl;
import com.Model.HRregisterModel;
import com.DAOImpl.DaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HRregisterModel user = new HRregisterModel();
        user.setFirstName(request.getParameter("fullName"));
        user.setLastName(request.getParameter("lastName"));
        user.setGender(request.getParameter("gender"));
        user.setDob(request.getParameter("dob"));  // yyyy-MM-dd
        user.setMaritalStatus(request.getParameter("maritalStatus"));
        user.setCountry(request.getParameter("country"));
        user.setPhno(request.getParameter("phno"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));

        DaoImpl dao = new DaoImpl();
        boolean result = dao.registerUser(user);
		if (result) {
		    response.sendRedirect("login.html");
		} else {
		    response.getWriter().println("Registration failed!");
		}
    }
}