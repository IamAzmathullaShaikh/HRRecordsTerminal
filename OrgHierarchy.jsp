<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.Model.EmployeeDetails" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Organization Hierarchy</title>

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: "Segoe UI", Tahoma, sans-serif;
    background: #f5f7fa;
    color: #1f2933;
}


h2 {
    text-align: center;
    margin: 40px 0 20px;
    letter-spacing: 1px;
    font-size: 28px;
    font-weight: 700;
}

/* ===== Tree Layout ===== */
.tree {
    width: 100%;
    overflow-x: auto;
    padding-bottom: 40px;
}

.tree ul {
    padding-top: 30px;
    position: relative;
    transition: all 0.5s;
}

.tree li {
    float: left;
    text-align: center;
    list-style-type: none;
    position: relative;
    padding: 30px 10px 0 10px;
}

/* ===== Connector Lines ===== */
.tree li::before,
.tree li::after {
    content: '';
    position: absolute;
    top: 0;
    right: 50%;
    border-top: 2px solid #cbd5e1;
    width: 50%;
    height: 30px;
}

.tree li::after {
    right: auto;
    left: 50%;
    border-left: 2px solid #cbd5e1;
}

.tree li:only-child::after,
.tree li:only-child::before {
    display: none;
}

.tree li:only-child {
    padding-top: 0;
}

.tree li:first-child::before,
.tree li:last-child::after {
    border: 0 none;
}

.tree li:last-child::before {
    border-right: 2px solid #cbd5e1;
}

.tree ul ul::before {
    content: '';
    position: absolute;
    top: 0;
    left: 50%;
    border-left: 2px solid #cbd5e1;
    width: 0;
    height: 30px;
}

/* ===== Node Style ===== */
.tree li a {
    padding: 10px 18px;
    text-decoration: none;
    background: rgba(255,255,255,0.9);
    border-radius: 14px;
    display: inline-block;
    font-size: 14px;
    font-weight: 600;
    color: #1f2933;
    box-shadow: 0 10px 30px rgba(0,0,0,0.1);
    transition: all 0.3s ease;
    border: 1px solid #e5e7eb;
    backdrop-filter: blur(8px);
}

/* Hover effect */
.tree li a:hover {
    transform: translateY(-4px);
    box-shadow: 0 18px 45px rgba(0,0,0,0.18);
    background: linear-gradient(135deg, #2c5364, #1f4037);
    color: #ffffff;
    border-color: transparent;
}

/* ===== Role-based emphasis (visual only) ===== */
.tree > ul > li > a {
    background: linear-gradient(135deg, #1f4037, #2c5364);
    color: white;
}



/* Clear floats */
.tree ul::after {
    content: "";
    display: table;
    clear: both;
}
</style>

</head>
<body>

<h2>ORGANIZATIONAL STRUCTURE</h2>

<div class="tree">
<ul>

<!-- ================= CEO ================= -->
<li>
    <a>CEO</a>
    <ul>
        <%
            List<EmployeeDetails> ceoList =
                (List<EmployeeDetails>) request.getAttribute("ceoList");
            for (EmployeeDetails ceo : ceoList) {
        %>
        <li>
            <a><%= ceo.getEmployeeName() %></a>
            <ul>

                <!-- ================= HR ================= -->
                <li>
                    <a>HR</a>
                    <ul>
                        <%
                            List<EmployeeDetails> hrList =
                                (List<EmployeeDetails>) request.getAttribute("hrList");
                            for (EmployeeDetails hr : hrList) {
                        %>
                        <li>
                            <a><%= hr.getEmployeeName() %></a>
                            <ul>

                                <!-- ========== DEPARTMENTS ========== -->
                                <%
                                    Map<String, Map<String, List<EmployeeDetails>>> deptHierarchy =
                                        (Map<String, Map<String, List<EmployeeDetails>>>)
                                            request.getAttribute("deptHierarchy");

                                    for (Map.Entry<String, Map<String, List<EmployeeDetails>>> dept
                                            : deptHierarchy.entrySet()) {
                                %>

                                <li>
                                    <a><%= dept.getKey() %></a>
                                    <ul>

                                        <!-- ========== ROLES ========== -->
                                        <%
                                            for (Map.Entry<String, List<EmployeeDetails>> role
                                                    : dept.getValue().entrySet()) {
                                        %>
                                        <li>
                                            <a><%= role.getKey() %></a>
                                            <ul>

                                                <!-- ========== EMPLOYEES ========== -->
                                                <%
                                                    for (EmployeeDetails emp : role.getValue()) {
                                                %>
                                                <li>
                                                    <a><%= emp.getEmployeeName() %></a>
                                                </li>
                                                <% } %>

                                            </ul>
                                        </li>
                                        <% } %>

                                    </ul>
                                </li>
                                <% } %>

                            </ul>
                        </li>
                        <% } %>
                    </ul>
                </li>

            </ul>
        </li>
        <% } %>
    </ul>
</li>

</ul>
</div>

</body>
</html>
