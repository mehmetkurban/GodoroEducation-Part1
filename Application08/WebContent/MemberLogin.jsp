<%@page import="com.godoro.membership.entity.Member"%>
<%@page import="com.godoro.sports.repository.MemberRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message="Bilgileri Girin";
	if(request.getParameter("login")!=null){
		String memberUsername=request.getParameter("memberUsername");
		String memberPassword=request.getParameter("memberPassword");
		
		MemberRepository memberRepository=new MemberRepository();
		Member member =memberRepository.findByUserName(memberUsername);
		if(member==null){
			message="Üye bulunamadı";
		}else if(!member.getMemberPassword().equals(memberPassword)){
			message="Yanlış Şifre";
		}else{
			session.setAttribute("memberUsername",memberUsername);
			response.sendRedirect("MemberHome.jsp");
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
<%=message%>
	<form action="MemberLogin.jsp" method="POST">
	Kullanıcı Adı:<input type="text" name="memberUsername"/><br>
	Kullanıcı Parolası:<input type="password" name="memberPassword"/><br>
	<input type="submit" value="Gir" name="login"/>
	</form>
</body>
</html>