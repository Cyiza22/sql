package org.example.repositories;

import org.example.base.Mark;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarkRepository implements Repository<Mark, Integer> {
    private final Connection conn;

    public MarkRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void create(Mark mark) {
        String sql = "INSERT INTO marks (student_id, course_id, score) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, mark.getStudentId());
            stmt.setInt(2, mark.getCourseId());
            stmt.setDouble(3, mark.getScore());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Mark findById(Integer id) {
        String sql = "SELECT * FROM marks WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Mark(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getDouble("score")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Mark> findAll() {
        List<Mark> marks = new ArrayList<>();
        String sql = "SELECT * FROM marks";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Mark mark = new Mark(
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getDouble("score")
                );
                marks.add(mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marks;
    }

    @Override
    public void update(Mark mark, Integer id) {
        String sql = "UPDATE marks SET student_id = ?, course_id = ?, score = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, mark.getStudentId());
            stmt.setInt(2, mark.getCourseId());
            stmt.setDouble(3, mark.getScore());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM marks WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
