<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie=new Cookie("company","godoro");
	cookie.setMaxAge(30); //Kalıcı Cookie 30 sn sorun cıkarsa sil bunu
	response.addCookie(cookie);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Çerez eklendi:<%=cookie.getValue()%>
</body>
</html>