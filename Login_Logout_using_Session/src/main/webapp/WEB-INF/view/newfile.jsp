<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New File</title>
</head>
<body>
	<h1 style="color: red;"><% 
		if(request.getAttribute("msg")!=null){
			out.print(request.getAttribute("msg"));
		} 
	%></h1>
</body>
</html>	