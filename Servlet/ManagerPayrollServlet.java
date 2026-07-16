package com.Servlet;
import java.io.IOException;
import java.util.List;
import com.DAOImpl.DaoImpl;
import com.Model.EmployeeDetails;
import com.Model.PayrollDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ManagerPayrollServlet")
public class ManagerPayrollServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        EmployeeDetails manager = session != null ? 
                                  (EmployeeDetails) session.getAttribute("employee") : null;

        if (manager == null || !"Manager".equalsIgnoreCase(manager.getRole())) {
            resp.sendRedirect("ManagerLogin.jsp");
            return;
        }

        String department = manager.getDepartment();
        DaoImpl dao = new DaoImpl();
        List<PayrollDetails> payrollList = dao.getPayrollByDepartment(department);

        req.setAttribute("payrollList", payrollList);
        req.getRequestDispatcher("ManagerPayroll.jsp").forward(req, resp);
    }
}
