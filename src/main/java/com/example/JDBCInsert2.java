package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert2 {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    private final static String USER = "jpauser";
    private final static String PWD = "jpapwd";

    public static void main(String[] args) {
        Student student = new Student("Leo", "Farrel", 8.4);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PWD);) {

            Statement statement = conn.createStatement();
//            String sqlQuery = "INSERT INTO students (name, surname, avg_grade) VALUES ('Leo', 'Farrel', 8.4)";
            String sqlQuery = "INSERT INTO students (name, surname, avg_grade) VALUES " +
                    "('" +
                    student.getName() + "', '" +
                    student.getSurname() + "', " +
                    student.getAvgGrade() +
                    ")";
            statement.executeUpdate(sqlQuery);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
