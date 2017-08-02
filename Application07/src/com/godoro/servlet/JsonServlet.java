package com.godoro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/json")
public class JsonServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out=response.getWriter();
		String json="{ \r\n"
				    +"\t\"productId\": 123,\r\n"
				    +"\t\"productName\":\"Cep Telefonu\",\r\n"
				    +"\t\"salesPrice\":450\r\n"
				    +"}";
		out.println(json);
			
	}

}
