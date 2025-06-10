package org.example;

import java.sql.*;
import java.util.Scanner;

public class UnsafeQueryManager {
    public void queryDatabase(String username, String password, String url) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter EmployeeID:");
            String employeeId = scanner.nextLine();

            String query = "SELECT FirstName, LastName, Notes FROM Employees WHERE EmployeeID = " + employeeId;
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    System.out.println("Employee: " + rs.getString("FirstName") + " " + rs.getString("LastName") + " " + rs.getString("Notes"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

