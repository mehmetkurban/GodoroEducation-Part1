<%@page import="com.godoro.membership.entity.Member"%>
<%@page import="com.godoro.sports.repository.MemberRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String message="Bilgileri Girin";
	if(request.getParameter("register")!=null){
		String memberUsername=request.getParameter("memberUsername");
		String memberPassword=request.getParameter("memberPassword");
		String memberPassword2=request.getParameter("memberPassword2");
		if(memberPassword.equals(memberPassword2)){
			
			Member member=new Member();
			member.setMemberUsername(memberUsername);
			member.setMemberPassword(memberPassword);
			MemberRepository memberRepository=new MemberRepository();
			boolean inserted=memberRepository.insert(member);
			message="Kayıt Başarılı";
			if(inserted){
				message="Kayıt Başarılı";
			}else{
				message="Bir Yanlışlık oldu.";
			}	
		}else{
			message="Bir Yanlışlık oldu.";
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
	<form action="MemberRegister.jsp" method="POST">
	Kullanıcı Adı:<input type="text" name="memberUsername"/><br>
	Kullanıcı Parolası:<input type="password" name="memberPassword"/><br>
	Kullanıcı Parolası(Tekrar):<input type="password" name="memberPassword2"/><br>
	<input type="submit" value="Gir" name="register"/>
	</form>
</body>
</html>