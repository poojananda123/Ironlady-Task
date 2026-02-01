<%
    // SESSION CHECK
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<%@ page import="java.util.*, model.Learner" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

.logout-btn {
    background: #dc3545;
    color: white;
    padding: 8px 16px;
    border-radius: 5px;
    font-size: 14px;
    font-weight: 600;
    text-decoration: none;
    transition: 0.3s;
}
.logout-btn:hover { background: #b52a37; }

/* CONTAINER */
.container {
    max-width: 1200px;
    margin: 35px auto;
    background: white;
    padding: 25px 35px;
    border-radius: 8px;
    box-shadow: 0 8px 22px rgba(0,0,0,0.08);
}

/* SUMMARY CARDS */
.cards {
    display: flex;
    gap: 20px;
    margin-bottom: 25px;
    flex-wrap: wrap;
}

.card {
    flex: 1;
    min-width: 180px;
    background: #007bff;
    color: white;
    padding: 20px;
    border-radius: 8px;
    text-align: center;
    box-shadow: 0 6px 15px rgba(0,0,0,0.1);
    transition: 0.3s;
}
.card:hover { transform: translateY(-3px); box-shadow: 0 8px 18px rgba(0,0,0,0.15); }
.card h3 { margin: 0; font-size: 28px; }
.card p { margin: 5px 0 0; font-size: 14px; opacity: 0.9; }

/* PAGE TOP */
.page-top {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 18px;
}

.page-title h2 { margin: 0; font-size: 22px; color: #333; }
.page-title p { margin: 4px 0 0; font-size: 13px; color: #666; }

.add-btn {
    background: #28a745;
    color: white;
    padding: 10px 18px;
    border-radius: 6px;
    font-size: 14px;
    font-weight: 600;
    text-decoration: none;
    transition: 0.3s;
}
.add-btn:hover { background: #1e7e34; }

/* TABLE */
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 15px;
    font-size: 15px;
}

th, td { padding: 12px 14px; text-align: center; }
th { background: #f1f3f6; color: #333; font-weight: 600; border-bottom: 2px solid #ddd; }
tr:nth-child(even) { background: #fafafa; }
tr:hover { background: #eef3ff; }

.action-btn {
    padding: 6px 12px;
    border-radius: 5px;
    color: white;
    font-size: 13px;
    margin: 0 3px;
    text-decoration: none;
    font-weight: 500;
}

.edit { background: #28a745; }
.delete { background: #dc3545; }
.edit:hover { background: #1e7e34; }
.delete:hover { background: #a71d2a; }

.footer { margin-top: 25px; font-size: 12px; text-align: center; color: #777; }

</style>
</head>
<body>

<div class="header">
    <div>
        <h1>IRON LADY</h1>
        <span>Internal Operations Portal</span>
    </div>
    <a href="login.jsp" class="logout-btn">Logout</a>
</div>

<div class="container">

    <%
        // Safe fallback if list is null
        List<Learner> list = (List<Learner>) request.getAttribute("list");
        if(list == null) list = new ArrayList<>();

        int total = list.size();
        int enrolled = 0;
        int completed = 0;

        for(Learner l : list){
            if("Enrolled".equalsIgnoreCase(l.getStatus())) enrolled++;
            if("Completed".equalsIgnoreCase(l.getStatus())) completed++;
        }
    %>

    <!-- SUMMARY CARDS -->
    <div class="cards">
        <div class="card">
            <h3><%= total %></h3>
            <p>Total Learners</p>
        </div>
        <div class="card" style="background: #17a2b8;">
            <h3><%= enrolled %></h3>
            <p>Enrolled Learners</p>
        </div>
        <div class="card" style="background: #6c757d;">
            <h3><%= completed %></h3>
            <p>Completed Learners</p>
        </div>
    </div>

    <!-- PAGE TOP -->
    <div class="page-top">
        <div class="page-title">
            <h2>Learner Management</h2>
            <p>Manage learner details, enrollment status, and program information</p>
        </div>
        <a href="add-learner.jsp" class="add-btn">+ Add Learner</a>
    </div>

    <!-- TABLE -->
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Program</th>
            <th>Status</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Actions</th>
        </tr>

        <%
        if(!list.isEmpty()){
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
                <a class="action-btn delete"
                   href="delete?id=<%= l.getId() %>"
                   onclick="return confirm('Are you sure you want to delete this learner?');">
                   Delete
                </a>
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

    <div class="footer">
        © 2026 Iron Lady • Internal Use Only
    </div>

</div>

</body>
</html>
