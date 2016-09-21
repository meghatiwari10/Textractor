<%@ page import="ocrtesseract.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	TesseractEx c = new TesseractEx();
	String filepath = request.getParameter("filepath");
	//out.println(c);
	//out.println(aa);
	String result = c.performocr(filepath);
	out.println(result);
	
	
	//out.println(aa);
	
%>
</body>
</html>