<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>
    <h2>Login</h2>
    <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <p style="color: red;"><%
    	if(request.getAttribute("error") != null){
    		out.print(request.getAttribute("error"));
    	}
    %></p>
        
        <input type="submit" value="Login">
    </form>
    
    <p>${message}</p> <!-- Display an error message here if needed -->
    
    <p>Don't have an account? <a href="signup.jsp">Sign up</a></p>
    <p>Forgot your password? <a href="forgotpassword.jsp">Forgot password</a></p>
    
    <p style="color: red;"><%
    	if(request.getAttribute("error") != null){
    		out.print(request.getAttribute("error"));
    	}
    %></p>
</body>
</html>
