package com.Servlet;

import java.io.IOException;
import java.util.List;

import com.DAOImpl.DaoImpl;
import com.Model.AttendanceSummary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HRAttendanceServlet")
public class HRAttendanceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DaoImpl dao = new DaoImpl();
        List<AttendanceSummary> list = dao.getAllAttendanceSummary();

        request.setAttribute("attendanceList", list);
        request.getRequestDispatcher("hrAttendance.jsp").forward(request, response);
    }
}
