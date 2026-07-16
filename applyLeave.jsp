<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <form action="ApplyLeaveServlet" method="post">
    From: <input type="date" name="fromDate" required><br>
    To: <input type="date" name="toDate" required><br>
    Reason: <input type="text" name="reason"><br>
    <button type="submit">Apply Leave</button>
</form>
    