package com.godoro.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.json.*;


public class HttpClientJAXP {

	public static void main(String[] args) throws Exception {
		//String address="http://www.google.com";
		//String address="http://localhost:8080/Application07/xml";
		String address="http://localhost:8080/Application07/json";
		URL url=new URL(address);
		URLConnection connection=url.openConnection();

		//String string=read(connection.getInputStream());
		//System.out.println("Sonuç:\r\n"+string);
		
		JsonReader jsonReader=Json.createReader(connection.getInputStream());
		JsonObject jsonObject=jsonReader.readObject();
		jsonReader.close();
		
		long productId=jsonObject.getJsonNumber("productId").longValue();
		String productName=jsonObject.getString("productName");
		double salesPrice=jsonObject.getJsonNumber("salesPrice").doubleValue();
		
		/*
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document document=builder.parse(connection.getInputStream());
		Element product=document.getDocumentElement();
		long productId=Long.parseLong(product.getAttribute("productId"));
		String productName=product.getElementsByTagName("productName").item(0).getTextContent();
		double salesPrice=Double.parseDouble(product.getElementsByTagName("salesPrice").item(0).getTextContent());
		*/
		System.out.println("Ürün No"+productId
							+"\nAdý"+productName
							+"\nFiyatý"+salesPrice);
		
	
	}
	
	public static String read(InputStream is)throws Exception{
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(is,"utf-8"));
		StringBuilder builder=new StringBuilder();
		
		String line;
		while((line=reader.readLine())!=null){
			builder.append(line).append("\r\n");
		}
		reader.close();
		return builder.toString();
		
	}

}
