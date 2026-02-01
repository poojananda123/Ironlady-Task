<%@ page import="model.Learner" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
if(session.getAttribute("admin") == null){
    response.sendRedirect("login.jsp");
    return;
}
%>
<head>
<meta charset="UTF-8">
<title>Iron Lady | Edit Learner</title>

<style>
body {
    margin: 0;
    font-family: "Segoe UI", Arial, sans-serif;
    background: #f4f6f9;
}

/* Header */
.header {
    background: #1f3c88;
    padding: 16px 40px;
    color: white;
}

.header h1 {
    margin: 0;
    font-size: 20px;
    font-weight: 600;
}

/* Card */
.container {
    width: 420px;
    margin: 60px auto;
    background: #ffffff;
    padding: 28px 32px;
    border-radius: 10px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.08);
}

h2 {
    text-align: center;
    margin: 0;
    font-size: 22px;
    color: #333;
}

.subtitle {
    text-align: center;
    font-size: 13px;
    color: #666;
    margin-bottom: 22px;
}

/* Form */
label {
    display: block;
    margin-top: 14px;
    font-weight: 600;
    font-size: 14px;
    color: #444;
}

input, select {
    width: 100%;
    padding: 10px 12px;
    margin-top: 6px;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 14px;
    transition: 0.2s;
}

input:focus, select:focus {
    border-color: #1f3c88;
    outline: none;
    box-shadow: 0 0 4px rgba(31,60,136,0.25);
}

/* Buttons */
.btn-group {
    display: flex;
    gap: 10px;
    margin-top: 26px;
}

.btn-primary {
    flex: 1;
    background: #1f3c88;
    color: white;
    border: none;
    padding: 11px;
    border-radius: 6px;
    font-size: 15px;
    font-weight: 600;
    cursor: pointer;
}

.btn-primary:hover {
    background: #162c63;
}

.btn-secondary {
    flex: 1;
    background: #e0e0e0;
    color: #333;
    border: none;
    padding: 11px;
    border-radius: 6px;
    font-size: 15px;
    cursor: pointer;
}

.btn-secondary:hover {
    background: #cfcfcf;
}

/* Footer note */
.note {
    margin-top: 18px;
    font-size: 12px;
    color: #777;
    text-align: center;
}
</style>
</head>

<body>

<%
Learner l = (Learner) request.getAttribute("learner");
%>


<div class="header">
    <h1>IRON LADY – Internal Operations</h1>
</div>

<div class="container">
    <h2>Edit Learner</h2>
    <div class="subtitle">
        Update learner details and current program status
    </div>

    <form method="post" action="edit">

        <input type="hidden" name="id" value="<%= l.getId() %>">

        <label>Full Name</label>
        <input type="text" name="name" value="<%= l.getName() %>" required>

        <label>Email Address</label>
        <input type="email" name="email" value="<%= l.getEmail() %>" required>

        <label>Phone Number</label>
        <input type="text" name="phone" value="<%= l.getPhone() %>" required>

        <label>Program</label>
        <input type="text" name="program" value="<%= l.getProgram() %>">

        <label>Status</label>
        <select name="status">
            <option <%= "Enquired".equals(l.getStatus()) ? "selected" : "" %>>Enquired</option>
            <option <%= "Enrolled".equals(l.getStatus()) ? "selected" : "" %>>Enrolled</option>
            <option <%= "Completed".equals(l.getStatus()) ? "selected" : "" %>>Completed</option>
        </select>

        <div class="btn-group">
            <button type="submit" class="btn-primary">Update Learner</button>
            <button type="button" class="btn-secondary"
                    onclick="window.location.href='view';">
                Cancel
            </button>
        </div>
    </form>

    <div class="note">
        Changes are saved immediately • Internal use only
    </div>
</div>

</body>
</html>
