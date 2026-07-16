package com.Servlet;

import java.io.IOException;
import java.util.List;

import com.DAOImpl.DaoImpl;
import com.Model.LeaveRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LeaveApprovalServlet")
public class LeaveApprovalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DaoImpl dao = new DaoImpl();

        String action = request.getParameter("action");
        String leaveIdStr = request.getParameter("leaveId");

        // 👉 Case 1: HR clicked Approve / Reject
        if (action != null && leaveIdStr != null) {

            int leaveId = Integer.parseInt(leaveIdStr);

            if ("approve".equalsIgnoreCase(action)) {
                dao.approveLeave(leaveId);
            } 
            else if ("reject".equalsIgnoreCase(action)) {
                dao.rejectLeave(leaveId);
            }

            // Reload page after update
            response.sendRedirect("LeaveApprovalServlet");
            return;
        }

        // 👉 Case 2: Just open Leave Requests page
        List<LeaveRequest> leaveList = dao.getAllLeaveRequests();
        request.setAttribute("leaveList", leaveList);
        request.getRequestDispatcher("HRLeaveList.jsp").forward(request, response);
    }
}
