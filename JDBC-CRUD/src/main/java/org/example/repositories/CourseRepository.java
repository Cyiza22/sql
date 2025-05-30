package org.example.repositories;

import org.example.base.Course;
import org.example.db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements Repository<Course, Integer> {

    public CourseRepository(Connection conn) {
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            var stmt = conn.prepareStatement("SELECT * FROM Courses");
            var rs = stmt.executeQuery();
            while (rs.next()) {
                courses.add(new Course(
                        rs.getInt("id"),
                        rs.getString("course_name"),
                        rs.getString("course_description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public Course findById(Integer id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            var stmt = conn.prepareStatement("SELECT * FROM Courses WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Course(
                        rs.getInt("id"),
                        rs.getString("course_name"),
                        rs.getString("course_description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void create(Course course) {

        try (Connection conn = DatabaseConnection.getConnection()) {
            var stmt = conn.prepareStatement(
                    "INSERT INTO Courses ( course_name, course_description) VALUES ( ?, ?)");
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getCourseDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting course: " + e.getMessage());
        }
    }



    @Override
    public void update(Course course, Integer id) {
        String sql = "UPDATE Courses SET course_name = ?, course_description = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection()) {
            var stmt = conn.prepareStatement(sql);
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getCourseDescription());
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM Courses WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
