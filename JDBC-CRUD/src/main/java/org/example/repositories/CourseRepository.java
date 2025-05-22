package org.example.repositories;

import org.example.base.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements Repository<Course, Integer> {
    private final Connection connection;

    public CourseRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Courses")) {
            while (rs.next()) {
                Course course = new Course(
                        rs.getInt("id"),
                        rs.getString("course_name"),
                        rs.getString("course_description")
                );
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public Course findById(Integer id) {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Courses WHERE id = ?")) {
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
    public void deleteById(Integer id) {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM Courses WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Course course) {
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO Courses (course_name, course_description) VALUES (?, ?)")) {
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getCourseDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Course course, Integer id) {
        try (PreparedStatement stmt = connection.prepareStatement("UPDATE Courses SET course_name = ?, course_description = ? WHERE id = ?")) {
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getCourseDescription());
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

