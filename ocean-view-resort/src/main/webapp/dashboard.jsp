<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Ocean View Resort🌊 | Dashboard</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/theme.css">
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

        <!-- Action Cards -->
        <div class="card-grid">

            <div class="card">
                <a href="reservation.jsp">➕ Add Reservation</a>
                <p>Create a new guest booking</p>
            </div>

            <div class="card">
                <a href="${pageContext.request.contextPath}/viewReservation">📄 View Reservations</a>
                <p>Browse all reservations</p>
            </div>

            <div class="card">
                <a href="reservation.jsp">💰 Create & Calculate Bill</a>
                <p>Create reservation to generate bill</p>
            </div>

            <div class="card">
                <a href="help.jsp">❓ Help</a>
                <p>System usage guidelines</p>
            </div>

        </div>

        <!-- Room Status Section -->
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