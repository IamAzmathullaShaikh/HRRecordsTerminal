package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.DAOImpl.DaoImpl;
import com.Model.EmployeeDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/OrgHierarchyServlet")
public class OrgHierarchyServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("OrgHierarchyServlet HIT");

        DaoImpl dao = new DaoImpl();
        List<EmployeeDetails> list = dao.getAllEmployees();

        List<EmployeeDetails> ceo = new ArrayList<>();
        List<EmployeeDetails> hr = new ArrayList<>();

        Map<String, Map<String, List<EmployeeDetails>>> deptHierarchy =
                new LinkedHashMap<>();

        deptHierarchy.put("IT", new LinkedHashMap<>());
        deptHierarchy.put("Non IT", new LinkedHashMap<>());

        for (EmployeeDetails e : list) {
            if ("CEO".equalsIgnoreCase(e.getRole())) ceo.add(e);
            else if ("HR".equalsIgnoreCase(e.getRole())) hr.add(e);
            else {
                String dept =
                        "IT".equalsIgnoreCase(e.getDepartment()) ? "IT" : "Non IT";

                deptHierarchy
                    .computeIfAbsent(dept, d -> new LinkedHashMap<>())
                    .computeIfAbsent(e.getRole(), r -> new ArrayList<>())
                    .add(e);
            }
        }

        request.setAttribute("ceoList", ceo);
        request.setAttribute("hrList", hr);
        request.setAttribute("deptHierarchy", deptHierarchy);

        request.getRequestDispatcher("OrgHierarchy.jsp")
               .forward(request, response);
    }
}
