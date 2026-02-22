<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Ocean View Resort🌊 | Home</title>

    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    <!-- Home CSS -->
    <link rel="stylesheet" href="css/home.css">
</head>

<body>

<div class="home-bg">
    <div class="overlay">

        <!-- Branding Section -->
        <div class="brand glass-box">
            <i class="fa-solid fa-hotel"></i>
            <h1>Ocean View Resort</h1>
            <p class="tagline">Luxury • Comfort • Oceanfront Experience</p>
        </div>

        <!-- Introduction Section -->
        <div class="glass-box welcome-box">
            <p class="welcome-text">
                Welcome to <strong>Ocean View Resort</strong>, where elegance meets
                breathtaking sea views.
                <br><br>
                Our management system enables staff to efficiently handle
                reservations, billing, and guest services with accuracy and ease.
            </p>
        </div>

        <!-- Login Actions -->
        <div class="login-actions">
            <a href="login.jsp?role=admin" class="cta-btn admin-btn">
                <i class="fa-solid fa-user-shield"></i>
                Admin Login
            </a>

            <a href="login.jsp?role=staff" class="cta-btn staff-btn">
                <i class="fa-solid fa-user"></i>
                Staff Login
            </a>
        </div>

        <!-- Footer -->
        <div class="footer">
            © 2026 Ocean View Resort
        </div>

    </div>
</div>

</body>
</html>