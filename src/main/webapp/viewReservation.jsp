<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List,com.oceanview.model.Reservation" %>

<%
if(session.getAttribute("username") == null){
    response.sendRedirect(request.getContextPath()+"/login.jsp");
    return;
}

List<Reservation> reservations =
(List<Reservation>)request.getAttribute("reservations");
%>

<!DOCTYPE html>
<html>
<head>
<title>Ocean View Resort | Reservations</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Segoe UI, Arial, sans-serif;
}

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
            color: #fff;
        }

/* glass container */

.container{
width:95%;
max-width:1100px;

background:rgba(255,255,255,0.1);
backdrop-filter:blur(15px);
-webkit-backdrop-filter:blur(15px);

border-radius:18px;
padding:30px;

box-shadow:0 8px 32px rgba(0,0,0,0.4);
border:1px solid rgba(255,255,255,0.2);
}

/* title */

h2{
text-align:center;
margin-bottom:20px;
letter-spacing:1px;
}

/* table */

table{
width:100%;
border-collapse:collapse;
overflow:hidden;
border-radius:10px;
}

th,td{
padding:12px;
text-align:center;
}

th{
background:rgba(0,0,0,0.6);
font-weight:600;
}

td{
border-bottom:1px solid rgba(255,255,255,0.15);
}

tr:hover{
background:rgba(255,255,255,0.08);
}

/* buttons */

.btn{
padding:6px 12px;
border-radius:6px;
text-decoration:none;
color:white;
font-size:14px;
transition:0.3s;
}

.edit{
background:#28a745;
}

.delete{
background:#dc3545;
}

.btn:hover{
opacity:0.85;
}

/* top buttons */

.top-btn{
position:absolute;
top:20px;
padding:8px 14px;

background:rgba(255,255,255,0.15);
backdrop-filter:blur(10px);

border-radius:8px;
color:white;
text-decoration:none;
font-size:14px;
transition:0.3s;
}

.top-btn:hover{
background:rgba(255,255,255,0.25);
}

</style>
</head>

<body>

<a class="top-btn" style="left:20px;"
href="<%=request.getContextPath()%>/dashboard.jsp">
⬅ Dashboard
</a>

<a class="top-btn" style="right:20px;"
href="<%=request.getContextPath()%>/help.jsp">
❓ Help
</a>

<div class="container">

<h2>🌊 All Reservations</h2>

<table>

<tr>
<th>ID</th>
<th>Guest</th>
<th>Address</th>
<th>Contact</th>
<th>Email</th>
<th>Room</th>
<th>Nights</th>
<th>Check In</th>
<th>Check Out</th>
<th>Actions</th>
</tr>

<%
if(reservations != null && !reservations.isEmpty()){

for(Reservation r : reservations){
%>

<tr>

<td><%=r.getId()%></td>
<td><%=r.getGuestName()%></td>
<td><%=r.getAddress()%></td>
<td><%=r.getContact()%></td>
<td><%=r.getEmail()%></td>
<td><%=r.getRoomType()%></td>
<td><%=r.getNights()%></td>
<td><%=r.getCheckIn()%></td>
<td><%=r.getCheckOut()%></td>

<td>

<a class="btn edit"
href="<%=request.getContextPath()%>/editReservation?id=<%=r.getId()%>">
Edit
</a>

<a class="btn delete"
href="<%=request.getContextPath()%>/deleteReservation?id=<%=r.getId()%>"
onclick="return confirm('Delete reservation?');">
Delete
</a>

</td>

</tr>

<%
}

}else{
%>

<tr>
<td colspan="9">No reservations found</td>
</tr>

<%
}
%>

</table>

</div>

</body>
</html>