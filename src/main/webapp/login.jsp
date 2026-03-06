<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Ocean View Resort🌊 | Login</title>

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<%
if(session.getAttribute("user") != null){
    response.sendRedirect("dashboard.jsp");
    return;
}
%>

<style>

body{
margin:0;
font-family:Segoe UI,Arial,sans-serif;
background:url("images/login.jpg") no-repeat center center fixed;
background-size:cover;
}

.overlay{
height:100vh;
display:flex;
justify-content:center;
align-items:center;
flex-direction:column;
text-align:center;
}

h1{
color:rgb(0, 0, 0);
margin-bottom:20px;
font-size:60px;
}

p{
color:#f1f1f1;
margin-bottom:25px;
}

.login-box{
width:340px;
padding:30px;
background:rgba(255,255,255,0.18);
backdrop-filter:blur(12px);
border-radius:14px;
box-shadow:0 10px 25px rgba(0,0,0,0.4);
text-align:left;
}

.login-box h2{
text-align:center;
color:#fff;
margin-bottom:20px;
}

label{
color:#fff;
font-size:14px;
}

input{
width:100%;
margin:6px 0 12px 0;
padding:11px;
border:none;
border-radius:6px;
background:#fff;
}

button{
width:100%;
padding:12px;
background:#0288d1;
color:white;
border:none;
border-radius:6px;
cursor:pointer;
}

button:hover{
background:#0277bd;
}

.error{
color:#ff8080;
text-align:center;
margin-top:10px;
}

</style>
</head>

<body>

<div class="overlay">

<h1><i class="fa-solid fa-hotel"></i> Ocean View Resort</h1>

<p>Welcome to luxury by the sea</p>

<div class="login-box">

<h2>Login</h2>

<form action="${pageContext.request.contextPath}/login" method="post">

<label>Username</label>
<input type="text" name="username" required>

<label>Password</label>
<input type="password" name="password" required>

<button type="submit">Login</button>

</form>

<%
String error = (String) request.getAttribute("error");
if(error != null){
%>

<p class="error"><%=error%></p>

<%
}
%>

</div>

</div>

</body>
</html>