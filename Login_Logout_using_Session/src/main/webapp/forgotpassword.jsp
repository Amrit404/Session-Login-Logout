<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Forgot Password</title>
    <link rel="stylesheet" type="text/css" href="forgotpassword.css">
</head>
<body>
    <h2>Forgot Password</h2>
    <form action="forgotpassword" method="get">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required><br><br>
        <label for="email">New Password:</label>
        <input type="password" id="password" name="newPassword" required><br><br>
        
        <input type="submit" value="Submit">
    </form>
    
    <p>${message}</p> <!-- Display a message here if needed -->
    
    <p>Remember your password? <a href="index.jsp">Log in</a></p>
    
    <p style="color: red;"><%
    	if(request.getAttribute("error") != null){
    		out.print(request.getAttribute("error"));
    	}
    %></p>
</body>
</html>
