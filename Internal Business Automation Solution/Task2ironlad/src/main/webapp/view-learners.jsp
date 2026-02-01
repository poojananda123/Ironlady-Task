<%@ page import="java.util.*, model.Learner" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // SESSION CHECK
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iron Lady | Learner Dashboard</title>

<style>
body {
    margin: 0;
    font-family: "Segoe UI", Arial, sans-serif;
    background: #f4f6f9;
}

/* HEADER */
.header {
    background: #1f3c88;
    padding: 18px 40px;
    color: white;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.header h1 { margin: 0; font-size: 22px; font-weight: 600; }
.header span { font-size: 13px; opacity: 0.9; }

.logout-btn, .add-btn {
    padding: 8px 18px;
    border-radius: 5px;
    font-size: 14px;
    font-weight: 600;
    color: white;
    text-decoration: none;
    margin-left: 10px;
    transition: 0.3s;
}

.logout-btn { background: #dc3545; }
.logout-btn:hover { background: #b52a37; }
.add-btn { background: #28a745; }
.add-btn:hover { background: #1e7e34; }

/* CONTAINER */
.container {
    max-width: 1200px;
    margin: 35px auto;
    background: white;
    padding: 25px 35px;
    border-radius: 8px;
    box-shadow: 0 8px 22px rgba(0,0,0,0.08);
}

/* TABLE STYLING */
.table-wrapper {
    overflow-x: auto;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    font-size: 15px;
    background: #fff;
}

th, td {
    padding: 14px 16px;
    text-align: center;
    border-bottom: 1px solid #ddd;
}

th {
    background-color: #f1f3f6;
    color: #333;
    font-weight: 600;
}

tr:nth-child(even) { background-color: #fafafa; }
tr:hover { background-color: #eef3ff; }

.action-btn {
    padding: 6px 12px;
    border-radius: 5px;
    color: white;
    font-size: 13px;
    margin: 0 2px;
    font-weight: 500;
    text-decoration: none;
}

.edit { background-color: #28a745; }
.edit:hover { background-color: #1e7e34; }
.delete { background-color: #dc3545; }
.delete:hover { background-color: #a71d2a; }

/* FOOTER */
.footer {
    margin-top: 25px;
    font-size: 12px;
    text-align: center;
    color: #777;
}
</style>
</head>
<body>

<div class="header">
    <div>
        <h1>IRON LADY</h1>
        <span>Internal Operations Portal</span>
    </div>
    <div>
        <a href="add-learner.jsp" class="add-btn">+ Add Learner</a>
        <a href="login.jsp" class="logout-btn">Logout</a>
    </div>
</div>

<div class="container">
    <div style="margin-bottom: 15px; text-align: center;">
        <h2 style="color:#333; font-size:22px; margin:0;">List of Learners</h2>
        <p style="color:#666; font-size:14px; margin:5px 0 0;">All registered learners in the system</p>
    </div>
    <div class="table-wrapper">
        <table>
            <tr>
                <th>Id</th>
                <th>Full Name</th>
                <th>Program Name</th>
                <th>Enrollment Status</th>
                <th>Email Address</th>
                <th>Contact Number</th>
                <th>Manage</th>
            </tr>

            <%
            List<Learner> list = (List<Learner>) request.getAttribute("list");
            if(list != null && !list.isEmpty()) {
                for(Learner l : list){
            %>
            <tr>
                <td><%= l.getId() %></td>
                <td><%= l.getName() %></td>
                <td><%= (l.getProgram() != null) ? l.getProgram() : "-" %></td>
                <td><%= (l.getStatus() != null) ? l.getStatus() : "-" %></td>
                <td><%= (l.getEmail() != null) ? l.getEmail() : "-" %></td>
                <td><%= (l.getPhone() != null) ? l.getPhone() : "-" %></td>
                <td>
                    <a class="action-btn edit" href="edit?id=<%= l.getId() %>">Edit</a>
                    <a class="action-btn delete" href="delete?id=<%= l.getId() %>" 
                       onclick="return confirm('Are you sure you want to delete this learner?');">Delete</a>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="7" style="color:#666;">No learner records found</td>
            </tr>
            <% } %>
        </table>
    </div>

    <div class="footer">
        © 2026 Iron Lady • Internal Use Only
    </div>

</div>

</body>
</html>
