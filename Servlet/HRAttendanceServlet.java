package com.Servlet;

import java.io.IOException;
import java.util.List;

import com.DAOImpl.DaoImpl;
import com.Model.AttendanceSummary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
