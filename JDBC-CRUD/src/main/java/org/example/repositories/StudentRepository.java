package org.example.repositories;

import org.example.db.DatabaseConnection;
import org.example.base.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements Repository<Student, Integer> {
    public StudentRepository(Connection conn ) {
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            var stmt = conn.prepareStatement("SELECT * FROM Students");
            var rs = stmt.executeQuery();
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getDate("date_of_birth")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student findById(Integer id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            var stmt = conn.prepareStatement("SELECT * FROM Students WHERE id = ?");
            stmt.setInt(1, id);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getDate("date_of_birth")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(Student student) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            var stmt = conn.prepareStatement(
                    "INSERT INTO Students(first_name, last_name, email, date_of_birth) VALUES (?, ?, ?, ?)");
            stmt.setString(1, student.firstName);
            stmt.setString(2, student.lastName);
            stmt.setString(3, student.email);
            stmt.setDate(4, student.dateOfBirth);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student, Integer id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            var stmt = conn.prepareStatement(
                    "UPDATE Students SET first_name = ?, last_name = ?, email = ?, date_of_birth = ? WHERE id = ?");
            stmt.setString(1, student.firstName);
            stmt.setString(2, student.lastName);
            stmt.setString(3, student.email);
            stmt.setDate(4, student.dateOfBirth);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            var stmt = conn.prepareStatement("DELETE FROM Students WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
