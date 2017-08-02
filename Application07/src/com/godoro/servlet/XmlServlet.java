package com.godoro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XmlServlet
 */
@WebServlet("/xml")
public class XmlServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/xml");
		PrintWriter out=response.getWriter();
		String xml="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				  +"<product productId=\"123\">\r\n"
				  +"\t<productName>Cep Telefonu</productName>\r\n"
				  +"\t<salesPrice>450</salesPrice>\r\n"
				  +"</product>";
		out.println(xml);
	}

}
