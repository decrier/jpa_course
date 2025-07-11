package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsert {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    private final static String USER = "jpauser";
    private final static String PWD = "jpapwd";

    public static void main(String[] args) {
        Student student = new Student("Chanel", "King", 9.1);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PWD);) {

            PreparedStatement statement = conn.prepareStatement("INSERT INTO students (name, surname, avg_grade) VALUES (?, ?, ?)");
            statement.setString(1, student.getName());
            statement.setString(1, student.getSurname());
            statement.setDouble(1, student.getAvgGrade());
            statement.executeUpdate();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
