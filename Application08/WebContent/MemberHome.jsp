<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String memberUsername=(String)session.getAttribute("memberUsername");
	if(memberUsername==null){
		response.sendRedirect("MemberLogin.jsp");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Hoşgeldiniz! <%=memberUsername%><br/>
<a href="MemberLogout.jsp">Çıkış</a>
</body>
</html>