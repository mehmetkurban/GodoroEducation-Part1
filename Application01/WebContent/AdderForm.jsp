<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
	int left=0;
	int right=0;
	int sum=0;
	if(request.getParameter("add")!=null){
		left=Integer.parseInt(request.getParameter("left"));
		right=Integer.parseInt(request.getParameter("right"));
		sum=left+right;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	Toplam:<%=sum%>
	<form action="AdderForm.jsp" method="POST">
		Sol:<input type="text" name="left" value="<%=left%>"/><br/>
		Sağ:<input type="text" name="right"value="<%=right%>"/><br/>
			<input type="submit" value="Topla" name="add"/><br/>
	</form>
</body>
</html>