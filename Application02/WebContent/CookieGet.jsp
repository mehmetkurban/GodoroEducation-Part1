<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String company="";
	if(request.getCookies()!=null){
		for(Cookie cookie:request.getCookies()){
			if(cookie.getName().equals("company")){
				company=cookie.getValue();	
			}
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Çerez Alındı:<%=company%>
</body>
</html>