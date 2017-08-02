<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     %>
<%
	String username = null;
	if(session.getAttribute("username") != null) {
		username = session.getAttribute("username").toString();
	}
	if (username == null || "".equals(username)) {
		response.sendRedirect("Login.jsp");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Hoşgeldin <%=username %></h1>
<a href="Logout.jsp">Logout</a>
</center>
</body>
</html>