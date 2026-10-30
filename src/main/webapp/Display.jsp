<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>
<%
String data1 =(String)application.getInitParameter("msg1");
String data2 =(String)application.getAttribute("msg2");

out.println("----------------ServletContext------------------<br><br>");
out.println("Data1 : "+data1+"<br><br>");
out.println("Data2 : "+data2+"<br><br>");



out.println("----------------Servletconfig------------------<br><br>");
out.println("Servletname :"+request.getAttribute("ServletName")+"<br><br>");
out.println("msg3 :"+request.getAttribute("msg3")+"<br><br>");


%>

</h1>

</center>
</body>
</html>