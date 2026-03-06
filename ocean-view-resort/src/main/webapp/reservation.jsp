<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ocean View Resort 🌊 | Reservation</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

<style>
    body {
        margin: 0;
        font-family: 'Segoe UI', Arial, sans-serif;
        background: url("${pageContext.request.contextPath}/images/res1.jpg")
                    no-repeat center center fixed;
        background-size: cover;
    }

    .overlay {
        background: rgba(0, 0, 0, 0.45);
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .glass-form {
        width: 420px;
        padding: 30px;
        background: rgba(255, 255, 255, 0.18);
        backdrop-filter: blur(12px);
        border-radius: 16px;
        border: 1px solid rgba(255,255,255,0.3);
        box-shadow: 0 10px 30px rgba(0,0,0,0.35);
        color: #fff;
    }

    .glass-form h2 {
        text-align: center;
        margin-bottom: 25px;
    }

    label {
        font-size: 14px;
    }

    input, select {
        width: 100%;
        margin: 8px 0 16px 0;
        padding: 12px;
        border-radius: 6px;
        border: none;
        background: rgba(255,255,255,0.85);
    }

    button {
        width: 100%;
        padding: 12px;
        background: linear-gradient(135deg, #0288d1, #26c6da);
        border: none;
        border-radius: 6px;
        color: #fff;
        font-size: 15px;
        cursor: pointer;
    }
</style>
</head>

<body>

<div class="overlay">

    <!-- Top navigation to dashboard -->
    <div style="position:absolute; top:20px; left:20px;">
        <a href="${pageContext.request.contextPath}/dashboard.jsp" style="color:#fff; text-decoration:none; background: rgba(0,0,0,0.4); padding:8px 12px; border-radius:6px;">⬅ Dashboard</a>
    </div>
    <div style="position:absolute; top:20px; right:20px;">
        <a href="${pageContext.request.contextPath}/help.jsp" style="color:#fff; text-decoration:none; background: rgba(0,0,0,0.4); padding:8px 12px; border-radius:6px;">❓ Help</a>
    </div>

    <!-- IMPORTANT: field names match ReservationServlet -->
    <form class="glass-form"
          action="${pageContext.request.contextPath}/reservation"
          method="post">

        <h2>Reservation Details</h2>

        <!-- Error messages -->
        <c:if test="${not empty errors}">
            <div style="background: rgba(255, 82, 82, 0.2); border:1px solid rgba(255,82,82,0.5); color:#fff; padding:10px; border-radius:6px; margin-bottom:12px;">
                <ul style="margin:0 0 0 18px;">
                    <c:forEach var="e" items="${errors}">
                        <li>${e}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>


        <label>Guest Name</label>
        <input type="text" name="guestName"
               value="${fn:escapeXml(guestName)}" required>

        <label>Address</label>
        <input type="text" name="address"
               value="${fn:escapeXml(address)}" required>

        <label>Contact</label>
        <input type="text" name="contact"
               value="${fn:escapeXml(contact)}" required>

        <!-- ✅ EMAIL ADDED -->
        <label>Email</label>
        <input type="email" name="email"
               value="${fn:escapeXml(email)}" required>

        <label>Room Type</label>
        <select name="roomType" required>
            <option value="">-- Select Room Type --</option>
            <option value="Standard" <c:if test="${roomType == 'Standard'}">selected</c:if>>Standard</option>
            <option value="Double"   <c:if test="${roomType == 'Double'}">selected</c:if>>Double</option>
            <option value="Deluxe"   <c:if test="${roomType == 'Deluxe'}">selected</c:if>>Deluxe</option>
        </select>


        <label>Check-in</label>
        <input type="date" name="checkIn" value="${checkIn}" required>

        <label>Check-out</label>
        <input type="date" name="checkOut" value="${checkOut}" required>

        <button type="submit">Save Reservation</button>

        <p style="color:#eee; font-size:12px; text-align:center; margin-top:8px;">
            Reservation ID, nights & created date are auto-calculated.
        </p>

    </form>

</div>

</body>
</html>