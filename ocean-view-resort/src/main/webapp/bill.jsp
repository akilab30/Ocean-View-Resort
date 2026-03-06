<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.oceanview.model.Reservation" %>

<%
    Reservation bill = (Reservation) session.getAttribute("bill");
    if (bill == null) {
        response.sendRedirect("dashboard.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ocean View Resort 🌊 | Bill</title>

<style>
    body {
        margin: 0;
        font-family: 'Segoe UI', Arial, sans-serif;
        background: url("<%=request.getContextPath()%>/images/bill3.jpg")
                    no-repeat center center fixed;
        background-size: cover;
    }

    .overlay {
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background: rgba(0, 0, 0, 0.45);
    }

    .glass-card {
        width: 420px;
        padding: 30px;
        background: rgba(255, 255, 255, 0.18);
        backdrop-filter: blur(12px);
        -webkit-backdrop-filter: blur(12px);
        border-radius: 16px;
        border: 1px solid rgba(255,255,255,0.3);
        box-shadow: 0 10px 30px rgba(0,0,0,0.35);
        color: #ffffff;
    }

    .glass-card h2 {
        text-align: center;
        margin-bottom: 20px;
        letter-spacing: 0.5px;
        color: #ffffff;
    }

    .bill-row {
        display: flex;
        justify-content: space-between;
        margin: 12px 0;
        font-size: 15px;
    }

    .total {
        margin-top: 20px;
        padding-top: 15px;
        border-top: 1px solid #e5e5e5;
        font-size: 18px;
        font-weight: bold;
    }

    .actions {
        margin-top: 25px;
        display: flex;
        gap: 10px;
    }

    .btn {
        flex: 1;
        padding: 12px;
        border: none;
        border-radius: 6px;
        font-size: 14px;
        cursor: pointer;
        background: linear-gradient(135deg, #0288d1, #26c6da);
        color: #ffffff;
        transition: 0.3s ease;
    }

    .btn:hover {
        transform: translateY(-2px);
        box-shadow: 0 6px 15px rgba(0,0,0,0.3);
    }

    @media print {
        body { background: white; }
        .overlay { background: none; }
        .actions { display: none; }
        .glass-card {
            background: white;
            color: black;
            box-shadow: none;
        }
    }
</style>
</head>

<body>
<div style="position:absolute; top:20px; left:20px;">
    <a href="${pageContext.request.contextPath}/dashboard.jsp" style="color:#fff; text-decoration:none; background: rgba(0,0,0,0.4); padding:8px 12px; border-radius:6px;">⬅ Dashboard</a>
</div>
<div style="position:absolute; top:20px; right:20px;">
    <a href="${pageContext.request.contextPath}/help.jsp" style="color:#fff; text-decoration:none; background: rgba(0,0,0,0.4); padding:8px 12px; border-radius:6px;">❓ Help</a>
</div>

<div class="overlay">
    <div class="glass-card">

        <h2>Final Bill</h2>

        <div class="bill-row">
            <span>Reservation ID</span>
            <span><%= bill.getId() %></span>
        </div>

        <div class="bill-row">
            <span>Guest Name</span>
            <span><%= bill.getGuestName() %></span>
        </div>

        <div class="bill-row">
            <span>Room Type</span>
            <span><%= bill.getRoomType() %></span>
        </div>

        <div class="bill-row">
            <span>Nights</span>
            <span><%= bill.getNights() %></span>
        </div>
        
        <div class="bill-row">
            <span>Contact No</span>
            <span><%= bill.getContact() %></span>
        </div>
       
        <div class="bill-row">
            <span>email</span>
            <span><%= bill.getEmail() %></span>
        </div>
       

        <div class="bill-row total">
            <span>Total Amount</span>
            <span>LKR <%= bill.getTotalAmount() %></span>
        </div>

        <!-- SINGLE ACTION BAR -->
        <div class="actions">
            <button class="btn btn-print"
                    onclick="window.location.href='<%=request.getContextPath()%>/bill-pdf'">
                Download PDF
            </button>

            <button class="btn btn-print" onclick="window.print()">
                Print
            </button>

        </div>

    </div>
</div>

</body>
</html>