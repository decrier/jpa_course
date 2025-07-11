package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInsert2upd {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    private final static String USER = "jpauser";
    private final static String PWD = "jpapwd";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PWD);) {

            Scanner scan = new Scanner(System.in);
            System.out.print("Enter name: ");
            String inputName = scan.nextLine();

            Statement statement = conn.createStatement();
            String sqlQuery = "UPDATE students SET avg_grade = 7.5 "+
                                "WHERE name = '" + inputName + "'";
            statement.executeUpdate(sqlQuery);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
