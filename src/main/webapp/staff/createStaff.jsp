<%@ page contentType="text/html;charset=UTF-8" %>

<%
if(session == null || session.getAttribute("username") == null){
    response.sendRedirect(request.getContextPath()+"/login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<title>Create Staff</title>

<style>

body{
    font-family:Arial;
    background:#0f2027;
    background:linear-gradient(to right,#2c5364,#203a43,#0f2027);
    color:white;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
    margin:0;
}

.overlay{
    position:relative;
    width:100%;
    height:100%;
    display:flex;
    justify-content:center;
    align-items:center;
}

.container{
    background:rgba(255,255,255,0.15);
    padding:30px;
    border-radius:15px;
    width:350px;
    backdrop-filter:blur(10px);
}

input{
    width:100%;
    padding:8px;
    margin:8px 0;
    border:none;
    border-radius:5px;
}

button{
    width:100%;
    padding:10px;
    background:#28a745;
    color:white;
    border:none;
    border-radius:5px;
    cursor:pointer;
}

button:hover{
    background:#218838;
}

.nav-btn{
    color:#fff;
    text-decoration:none;
    background:rgba(0,0,0,0.4);
    padding:8px 12px;
    border-radius:6px;
    font-size:14px;
}

.nav-btn:hover{
    background:rgba(0,0,0,0.7);
}

</style>
</head>

<body>

<div class="overlay">

    <!-- Dashboard Button -->
    <div style="position:absolute; top:20px; left:20px;">
        <a href="${pageContext.request.contextPath}/dashboard.jsp" class="nav-btn">
            ⬅ Dashboard
        </a>
    </div>

    <!-- Help Button -->
    <div style="position:absolute; top:20px; right:20px;">
        <a href="${pageContext.request.contextPath}/help.jsp" class="nav-btn">
            ❓ Help
        </a>
    </div>

    <div class="container">

        <h2>Create Staff</h2>

        <form action="<%=request.getContextPath()%>/createStaff" method="post">

            Name
            <input type="text" name="name" required>

            Role
            <input type="text" name="role" required>

            Contact
            <input type="text" name="contact">

            Email
            <input type="email" name="email">

            <button type="submit">Create Staff</button>

        </form>

    </div>

</div>

</body>
</html>