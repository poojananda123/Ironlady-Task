<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Iron Lady | Internal Portal Login</title>

<style>
body {
    margin: 0;
    padding: 0;
    font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
    background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
}

.login-box {
    width: 360px;
    background: #ffffff;
    padding: 35px 30px;
    border-radius: 12px;
    box-shadow: 0 15px 30px rgba(0, 0, 0, 0.25);
}

.brand {
    text-align: center;
    margin-bottom: 20px;
}

.brand h1 {
    margin: 0;
    font-size: 26px;
    color: #2c5364;
    letter-spacing: 1px;
}

.brand p {
    margin: 5px 0 0;
    font-size: 13px;
    color: #777;
}

h2 {
    text-align: center;
    font-size: 18px;
    margin: 25px 0 15px;
    color: #333;
}

input {
    width: 100%;
    padding: 12px;
    margin-top: 12px;
    border-radius: 6px;
    border: 1px solid #ccc;
    font-size: 14px;
}

input:focus {
    outline: none;
    border-color: #2c5364;
}

button {
    width: 100%;
    margin-top: 22px;
    padding: 12px;
    background: #2c5364;
    color: #ffffff;
    border: none;
    border-radius: 6px;
    font-size: 15px;
    font-weight: 600;
    cursor: pointer;
    transition: background 0.3s;
}

button:hover {
    background: #203a43;
}

.footer-text {
    text-align: center;
    margin-top: 18px;
    font-size: 12px;
    color: #888;
}
</style>
</head>


<body>

<div class="login-box">

    <div class="brand">
        <h1>IRON LADY</h1>
        <p>Internal Operations Portal</p>
    </div>

    <h2>Secure Login</h2>

    <form action="login" method="post">
        <input type="text" name="username" placeholder="Admin Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Sign In</button>
    </form>

    <div class="footer-text">
        © 2026 Iron Lady • Authorized Personnel Only
    </div>

</div>

</body>
</html>
