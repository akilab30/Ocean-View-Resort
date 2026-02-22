<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ocean View Resort🌊 | Login</title>

    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Arial, sans-serif;
            background: url("images/login.jpg") no-repeat center center fixed;
            background-size: cover;
        }

        .overlay {
            background: rgba(0, 0, 0, 0.45);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            text-align: center;
        }

        h1 {
            color: #ffffff;
            margin-bottom: 5px;
            letter-spacing: 2px;
            font-size: 66px;
        }

        h1 i {
            margin-right: 12px;
            color: #ffffff;
        }

        p {
            color: #ffffff;
            margin-bottom: 35px;
            font-size: 24px;
        }

        .login-box {
            width: 340px;
            padding: 30px;
            background: rgba(255, 255, 255, 0.18);
            backdrop-filter: blur(12px);
            -webkit-backdrop-filter: blur(12px);
            border-radius: 14px;
            border: 1px solid rgba(255,255,255,0.3);
            box-shadow: 0 10px 30px rgba(0,0,0,0.35);
        }

        .login-box h2 {
            color: #ffffff;
            margin-bottom: 20px;
        }

        input {
            width: 90%;
            margin: 12px 0;
            padding: 12px;
            border: none;
            border-radius: 6px;
            outline: none;
            background: rgba(255,255,255,0.85);
            font-size: 14px;
        }

        button {
            width: 100%;
            margin-top: 15px;
            padding: 12px;
            background: linear-gradient(135deg, #0288d1, #26c6da);
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 15px;
            cursor: pointer;
            transition: 0.3s ease;
        }

        button:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 15px rgba(0,0,0,0.3);
        }

        .error {
            color: #ff8a80;
            margin-top: 12px;
            font-size: 13px;
        }
    </style>
</head>

<body>

<div class="overlay">
    <h1>
        <i class="fa-solid fa-hotel"></i>
        Ocean View Resort
    </h1>

    <p>Welcome to luxury by the sea</p>

    <div class="login-box">
        <h2>Login</h2>

        <form action="login" method="post">
            <input type="text" name="username" placeholder="Username" required />
            <input type="password" name="password" placeholder="Password" required />
            <button type="submit">Login</button>
        </form>

        <%
            if (request.getParameter("errr") != null) {
        %>
            <p class="error">Invalid username or password</p>
        <%
            }
        %>
    </div>
</div>

</body>
</html>