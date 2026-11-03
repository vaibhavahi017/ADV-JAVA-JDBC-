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
<<<<<<< HEAD
out.println("Welcome "+request.getParameter("uname")+"<br><br>");
out.println("Data from Filter Config  "+"<br><br>");
out.println("Filter Name :"+request.getAttribute("Fname"+"<br><br>"));
out.println("msg1 :"+request.getAttribute("msg1")+"<br><br>" );

%>
</h1>

</center>

=======
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
>>>>>>> origin/main
</body>
</html>