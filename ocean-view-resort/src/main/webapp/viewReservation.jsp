<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, com.oceanview.model.Reservation" %>

<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }

    List<Reservation> reservations =
        (List<Reservation>) request.getAttribute("reservations");
%>

<!DOCTYPE html>
<html>
<head>
    <title>View Reservations</title>

    <style>
        body {
            min-height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background:
                linear-gradient(135deg, rgba(0,123,255,0.6), rgba(0,180,216,0.6)),
                url("<%= request.getContextPath() %>/images/hotel.jpg")
                no-repeat center center fixed;
            background-size: cover;

            display: flex;
            justify-content: center;
            align-items: center;
        }

        .glass-container {
            width: 95%;
            max-width: 1100px;
            padding: 30px;
            background: rgba(255,255,255,0.15);
            backdrop-filter: blur(12px);
            border-radius: 15px;
            color: #fff;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid rgba(255,255,255,0.3);
            text-align: center;
            font-size: 14px;
        }

        th {
            background: rgba(0,0,0,0.4);
        }

        tr:nth-child(even) {
            background: rgba(255,255,255,0.1);
        }

        .empty-msg {
            padding: 30px;
            text-align: center;
            font-style: italic;
        }

        .back-btn {
            display: inline-block;
            margin-top: 25px;
            padding: 10px 22px;
            background: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 25px;
        }
    </style>
</head>

<body>

<div class="glass-container">

    <h2>All Reservations</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Guest Name</th>
            <th>Address</th>
            <th>Contact</th>
            <th>Room Type</th>
            <th>Nights</th>
            <th>Check In</th>
            <th>Check Out</th>
        </tr>

        <%
            if (reservations != null && !reservations.isEmpty()) {
                for (Reservation r : reservations) {
        %>
        <tr>
            <td><%= r.getId() %></td>
            <td><%= r.getGuestName() %></td>
            <td><%= r.getAddress() %></td>
            <td><%= r.getContact() %></td>
            <td><%= r.getRoomType() %></td>
            <td><%= r.getNights() %></td>
            <td><%= r.getCheckIn() %></td>
            <td><%= r.getCheckOut() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="8" class="empty-msg">No reservations found</td>
        </tr>
        <% } %>

    </table>

    <div style="text-align:center;">
        <a href="<%= request.getContextPath() %>/dashboard.jsp"
           class="back-btn">⬅ Back to Dashboard</a>
    </div>

</div>

</body>
</html>