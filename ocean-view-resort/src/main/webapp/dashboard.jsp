
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ocean View Resort🌊 | Dashboard</title>

    <!-- Correct CSS link -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
</head>

<body>

<div class="dashboard-bg">

    <div class="glass-container">

        <!-- Top Bar -->
        <div class="top-bar">
            <h2>Ocean View Resort Dashboard</h2>
            <a class="logout-btn" href="${pageContext.request.contextPath}/logout">Logout</a>
        </div>

        <p>Welcome, <strong>${sessionScope.user}</strong>. Select an option below.</p>

        <!-- Cards -->
        <div class="card-grid">

            <div class="card">
                <a href="reservation.jsp">➕ Add Reservation</a>
                <p>Create a new guest booking</p>
            </div>

            <div class="card">
                <a href="viewReservation.jsp">📄 View Reservation</a>
                <p>Search reservation inquiry</p>
            </div>

            <div class="card">
                <a href="bill.jsp">💰 Calculate Bill</a>
                <p>Generate billing</p>
            </div>

            <div class="card">
                <a href="help.jsp">❓ Help</a>
                <p>System usage guidelines</p>
            </div>

        </div>

        <div class="footer">
        
            <p>|  © 2026 Ocean View Resort  |</p>
        </div>

    </div>

</div>

</body>
</html>