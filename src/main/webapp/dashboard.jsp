<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
if(session.getAttribute("user") == null){
response.sendRedirect("login.jsp");
return;
}
%>

<!DOCTYPE html>
<html>
<head>
<title>Ocean View Resort 🌊 | Dashboard</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/theme.css">

<style>

/* Background */
body{
margin:0;
font-family:'Segoe UI',sans-serif;
background:url("${pageContext.request.contextPath}/images/hotel.jpg") no-repeat center center fixed;
background-size:cover;
color:white;
}

/* Center Layout */
.dashboard-bg{
min-height:100vh;
display:flex;
justify-content:center;
align-items:center;
padding:30px;
}

/* Glass Container */
.glass-container{
width:1100px;
padding:35px;
border-radius:20px;
backdrop-filter:blur(15px);
background:rgba(255,255,255,0.15);
box-shadow:0 8px 32px rgba(0,0,0,0.4);
}

/* Top Bar */
.top-bar{
display:flex;
justify-content:space-between;
align-items:center;
margin-bottom:20px;
}

.logout-btn{
text-decoration:none;
padding:8px 16px;
background:#ff5252;
color:white;
border-radius:8px;
}

/* Card Grid */
.card-grid{
display:grid;
grid-template-columns:repeat(auto-fit,minmax(220px,1fr));
gap:20px;
margin-top:20px;
}

/* Glass Cards */
.card{
padding:20px;
border-radius:15px;
background:rgba(255,255,255,0.18);
backdrop-filter:blur(10px);
text-align:center;
transition:0.3s;
}

.card:hover{
transform:translateY(-5px);
background:rgba(255,255,255,0.25);
}

.card a{
font-size:18px;
font-weight:bold;
color:white;
text-decoration:none;
}

.card p{
font-size:13px;
margin-top:8px;
}

/* Room Status */
.room-status-section{
margin-top:40px;
}

.room-status-title{
margin-bottom:15px;
}

.room-status-grid{
display:grid;
grid-template-columns:repeat(3,1fr);
gap:20px;
}

.status-card{
padding:20px;
border-radius:15px;
text-align:center;
background:rgba(255,255,255,0.2);
}

.status-card h4{
margin:0;
}

.status-card span{
font-size:26px;
font-weight:bold;
}

/* Colors */
.occupied{
background:rgba(255,82,82,0.6);
}

.available{
background:rgba(76,175,80,0.6);
}

.maintenance{
background:rgba(255,193,7,0.6);
}

/* Footer */
.footer{
margin-top:30px;
text-align:center;
font-size:13px;
}

</style>

</head>

<body>

<div class="dashboard-bg">

<div class="glass-container">

<!-- Top Bar -->
<div class="top-bar">
<h2>Ocean View Resort Dashboard</h2>
<a class="logout-btn" href="${pageContext.request.contextPath}/logout">Logout</a>
</div>

<!-- Welcome -->
<p>
Welcome, <strong>${sessionScope.username}</strong>
(<strong>${sessionScope.role}</strong>)
</p>

<!-- Dashboard Cards -->
<div class="card-grid">

<div class="card">
<a href="${pageContext.request.contextPath}/reservation.jsp">➕ Add Reservation</a>
<p>Create a new guest booking</p>
</div>

<div class="card">
<a href="<%=request.getContextPath()%>/viewReservation">
View Reservations
</a>
<p>Browse all reservations</p>
</div>

<div class="card">
<a href="${pageContext.request.contextPath}/reservation.jsp">💰 Create & Calculate Bill</a>
<p>Create reservation to generate bill</p>
</div>

<div class="card">
<a href="${pageContext.request.contextPath}/help.jsp">❓ Help</a>
<p>System usage guidelines</p>
</div>

<!-- ADMIN ONLY -->
<c:if test="${sessionScope.role == 'ADMIN'}">

<div class="card">
<a href="${pageContext.request.contextPath}/createStaff">👨‍💼 Create Staff</a>
<p>Create new staff account</p>
</div>

<div class="card">
<a href="${pageContext.request.contextPath}/manageStaff">📋 Manage Staff</a>
<p>Edit or delete staff users</p>
</div>

</c:if>

</div>

<!-- Room Status -->
<div class="room-status-section">

<h3 class="room-status-title">Room Status Overview</h3>

<div class="room-status-grid">

<div class="status-card occupied">
<h4>Occupied</h4>
<span>${occupiedCount}</span>
</div>

<div class="status-card available">
<h4>Available</h4>
<span>${availableCount}</span>
</div>

<div class="status-card maintenance">
<h4>Maintenance</h4>
<span>${maintenanceCount}</span>
</div>

</div>

</div>

<div class="footer">
<p>| © 2026 Ocean View Resort |</p>
</div>

</div>

</div>

</body>
</html>