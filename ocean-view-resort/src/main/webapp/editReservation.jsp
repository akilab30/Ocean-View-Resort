<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.oceanview.model.Reservation" %>

<%
    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }

    Reservation r = (Reservation) request.getAttribute("reservation");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Reservation</title>

<style>
body {
    margin: 0;
    font-family: 'Segoe UI', Arial, sans-serif;
    background: url("<%= request.getContextPath() %>/images/res1.jpg")
                no-repeat center center fixed;
    background-size: cover;
}

.overlay {
    background: rgba(0,0,0,0.45);
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.glass-form {
    width: 450px;
    padding: 30px;
    background: rgba(255,255,255,0.18);
    backdrop-filter: blur(12px);
    border-radius: 16px;
    border: 1px solid rgba(255,255,255,0.3);
    box-shadow: 0 10px 30px rgba(0,0,0,0.35);
    color: #fff;
}

.glass-form h2 {
    text-align: center;
    margin-bottom: 20px;
}

label {
    font-size: 14px;
}

input {
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

button:hover {
    opacity: 0.9;
}

.nav-btn {
    position: absolute;
    top: 20px;
    left: 20px;
}

.nav-btn a {
    color: #fff;
    background: rgba(0,0,0,0.4);
    padding: 8px 12px;
    border-radius: 6px;
    text-decoration: none;
}
</style>
</head>

<body>

<div class="overlay">

    <!-- Back Button -->
    <div class="nav-btn">
        <a href="<%= request.getContextPath() %>/viewReservation">⬅ Back</a>
    </div>

    <form class="glass-form"
          action="${pageContext.request.contextPath}/updateReservation"
          method="post">

        <h2>Edit Reservation</h2>
        


        <input type="hidden" name="id" value="<%= r.getId() %>">

        <label>Guest Name</label>
        <input name="guestName" value="<%= r.getGuestName() %>" required>

        <label>Address</label>
        <input name="address" value="<%= r.getAddress() %>" required>

        <label>Contact</label>
        <input name="contact" value="<%= r.getContact() %>" required>

        <label>Email</label>
        <input name="email" type="email" value="<%= r.getEmail() %>" required>

        <label>Room Type</label>
        <input name="roomType" value="<%= r.getRoomType() %>" required>

        <label>Nights</label>
        <input name="nights" type="number" value="<%= r.getNights() %>" required>

        <label>Check In</label>
        <input type="date" name="checkIn"
               value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(r.getCheckIn()) %>" required>

        <label>Check Out</label>
        <input type="date" name="checkOut"
               value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(r.getCheckOut()) %>" required>

        <label>Total Amount</label>
        <input name="totalAmount" type="number" step="0.01"
               value="<%= r.getTotalAmount() %>" required>

        <button type="submit">Update Reservation</button>

    </form>

</div>

</body>
</html>