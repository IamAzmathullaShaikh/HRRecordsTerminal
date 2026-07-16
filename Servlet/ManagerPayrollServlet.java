package com.Servlet;
import java.io.IOException;
import java.util.List;
import com.DAOImpl.DaoImpl;
import com.Model.EmployeeDetails;
import com.Model.PayrollDetails;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
