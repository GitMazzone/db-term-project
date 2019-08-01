package com.dbtermproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.mindrot.jbcrypt.*;

public class BCryptLogin {

	public static void main(String[] args) throws SQLException {
		boolean inLoop = true;
		while(inLoop) {
			System.out.print("Type (n) for new user or (r) for returning user: ");
			Scanner keyboard = new Scanner(System.in);
			String answer = keyboard.nextLine();
			if(answer.toLowerCase().equals("n")) {
				System.out.print("Please enter your desired username: ");
				String username = keyboard.nextLine();
				System.out.print("Please enter you desired password: ");
				String password = keyboard.nextLine();
				
				String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
				
				String url = "jdbc:mysql://localhost/facebookaddata?"
						+ "useUnicode=true&"
						+ "useJDBCCompliantTimezoneShift=true&"
						+ "useLegacyDatetimeCode=false&"
						+ "serverTimezone=EST";
				String user = "root";
				String pass = "Gobraves1";
				Connection connection = DriverManager.getConnection(url, user, pass);
				Statement statement = connection.createStatement();
				int result = statement.executeUpdate("INSERT INTO users (username,password) VALUES ('" + username + "','" + hashedPassword + "');");
				connection.close();
			
			}
			else if(answer.toLowerCase().equals("r")) {
				System.out.print("Please enter your username: ");
				String username = keyboard.nextLine();
				System.out.print("Please enter you password: ");
				String password = keyboard.nextLine();
				

				String url = "jdbc:mysql://localhost/facebookaddata?"
						+ "useUnicode=true&"
						+ "useJDBCCompliantTimezoneShift=true&"
						+ "useLegacyDatetimeCode=false&"
						+ "serverTimezone=EST";
				String user = "root";
				String pass = "Gobraves1";
				Connection connection = DriverManager.getConnection(url, user, pass);
				Statement statement = connection.createStatement();
				
				ResultSet results = statement.executeQuery("SELECT password FROM users WHERE username = '" + username + "';");
				while(results.next()) {
					if(BCrypt.checkpw(password, results.getString("password"))) {
						System.out.println("Login Accepted");
					}
					else {
						System.out.println("Incorrect Login Credentials");
					}
				}
				
				break;
			}
			else {
				System.out.println("Incorrect option");
			}

		}
	}

}
