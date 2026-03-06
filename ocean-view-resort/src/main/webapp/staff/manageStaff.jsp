 <%@ page import="java.util.List,com.oceanview.model.Staff" %>

<%
if(session == null || session.getAttribute("username") == null){
response.sendRedirect(request.getContextPath()+"/login.jsp");
return;
}

List<Staff> staffList = (List<Staff>)request.getAttribute("staffList");
%>

<!DOCTYPE html>
<html>
<head>
<title>Manage Staff</title>

<style>

body{
font-family:Arial;
background:#0f2027;
background:linear-gradient(to right,#2c5364,#203a43,#0f2027);
color:white;
padding:40px;
}

.container{
width:90%;
margin:auto;
background:rgba(255,255,255,0.15);
padding:25px;
border-radius:15px;
}

table{
width:100%;
border-collapse:collapse;
}

th,td{
padding:10px;
border-bottom:1px solid rgba(255,255,255,0.3);
text-align:center;
}

th{
background:rgba(0,0,0,0.5);
}

.btn{
padding:6px 12px;
color:white;
text-decoration:none;
border-radius:5px;
}

.delete{
background:#dc3545;
}

</style>

</head>

<body>

<div class="container">

<h2>Manage Staff</h2>

<table>

<tr>
<th>ID</th>
<th>Name</th>
<th>Role</th>
<th>Contact</th>
<th>Email</th>
<th>Action</th>
</tr>

<%
if(staffList != null){

for(Staff s : staffList){
%>

<tr>

<td><%=s.getId()%></td>
<td><%=s.getName()%></td>
<td><%=s.getRole()%></td>
<td><%=s.getContact()%></td>
<td><%=s.getEmail()%></td>

<td>

<a class="btn delete"
href="<%=request.getContextPath()%>/deleteStaff?id=<%=s.getId()%>"
onclick="return confirm('Delete this staff?');">

Delete

</a>

</td>

</tr>

<%
}

}
%>

</table>

</div>

</body>
</html>