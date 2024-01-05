package com.web_app_mvc_chatgpt_01.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	Connection connection;
	Statement statement;
	
    private String jdbcURL = "jdbc:mysql://localhost:3306/student_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";
    
    public void connectDB() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    public void registerStudent(Student student) {
        try {
            String sql = "INSERT INTO signup (username, password, email) VALUES (?, ?, ?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getUsername());
            preparedStatement.setString(2, student.getPassword());
            preparedStatement.setString(3, student.getEmail());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updatePassword(String email,String newPassword) {
    	try {
			statement.executeUpdate("update signup set password = '"+newPassword+"' where email = '"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public boolean existByEmail(String email) {
		try {
			ResultSet result = statement.executeQuery("select * from signup where email = '"+email+"'");
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean logIn(String username, String password) {

		try {
			ResultSet result = statement.executeQuery("select * from signup where username = '"+username+"' "
					+ "and password = '"+password+"'");
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}

