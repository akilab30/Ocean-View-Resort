<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Help | Ocean View Resort</title>
    <style>
        /* Grayscale, high-contrast, simple layout */
        :root {
            --bg: #f5f5f5;
            --panel: #ffffff;
            --text: #111111;
            --muted: #555555;
            --border: #dddddd;
            --link: #000000;
            --link-hover: #333333;
            --btn: #222222;
            --btn-hover: #000000;
        }
        html, body { height: 100%; }
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
            background: var(--bg);
            color: var(--text);
        }
        .wrap {
            max-width: 900px;
            margin: 40px auto;
            background: var(--panel);
            border: 1px solid var(--border);
            border-radius: 10px;
            padding: 28px;
            box-shadow: 0 6px 20px rgba(0,0,0,0.06);
        }
        h1 { margin: 0 0 10px; font-size: 28px; }
        .muted { color: var(--muted); margin-bottom: 22px; }
        h2 { margin-top: 26px; font-size: 20px; }
        ol, ul { line-height: 1.6; }
        code { background: #f0f0f0; padding: 1px 6px; border-radius: 4px; }
        .topnav { display: flex; gap: 10px; margin-bottom: 16px; }
        .topnav a {
            display: inline-block;
            padding: 8px 12px;
            border: 1px solid var(--border);
            border-radius: 6px;
            color: var(--link);
            text-decoration: none;
            background: #fff;
        }
        .topnav a:hover { background: #f3f3f3; color: var(--link-hover); }
        .btn {
            display: inline-block;
            background: var(--btn);
            color: #fff;
            text-decoration: none;
            border-radius: 6px;
            padding: 10px 14px;
        }
        .btn:hover { background: var(--btn-hover); }
        .footer { margin-top: 26px; color: var(--muted); font-size: 13px; }
    </style>
</head>
<body>
<div class="wrap">
    <div class="topnav">
        <a href="<%= request.getContextPath() %>/index.jsp">Home</a>
        <a href="<%= request.getContextPath() %>/dashboard.jsp">Dashboard</a>
        <a href="<%= request.getContextPath() %>/reservation.jsp">Reservation</a>
        <a href="<%= request.getContextPath() %>/viewReservation">View Reservations</a>
    </div>

    <h1>Help & User Guide</h1>
    <div class="muted">Simple steps to use the Ocean View Resort system</div>

    <h2>1. Login</h2>
    <ul>
        <li>Open <code>http://localhost:8081/ocean-view-resort/index.jsp</code> and choose your role to navigate to the login page.</li>
        <li>Enter your username and password, then click <strong>Login</strong>.</li>
    </ul>

    <h2>2. Create a Reservation</h2>
    <ol>
        <li>From the Dashboard, click <strong>Add Reservation</strong>.</li>
        <li>Fill in guest details, select room type, and set check-in and check-out dates.</li>
        <li>Click <strong>Save Reservation</strong>. Nights are calculated automatically.</li>
    </ol>

    <h2>3. View Reservations</h2>
    <ul>
        <li>Go to <strong>View Reservations</strong> to see all saved reservations. Each reservation can be <strong>edited</strong> or <strong>deleted</strong> using the action buttons.</li>
        <li>Use your browser's print if you need a paper copy of the list.</li>
    </ul>

    <h2>4. Billing & PDF</h2>
    <ul>
        <li>Generate a bill after creating a reservation; totals are auto-calculated.</li>
        <li>Use <strong>Download PDF</strong> to export the bill. The PDF uses a clean grayscale style and no logo.</li>
    </ul>

    <h2>Support</h2>
    <p>If you encounter any issues, contact the admin or email: <strong>info@oceanview.com</strong></p>

    <p>
        <a class="btn" href="<%= request.getContextPath() %>/dashboard.jsp">Back to Dashboard</a>
    </p>

    <div class="footer">                        | © 2026 Ocean View Resort |</div>
</div>
</body>
</html>
