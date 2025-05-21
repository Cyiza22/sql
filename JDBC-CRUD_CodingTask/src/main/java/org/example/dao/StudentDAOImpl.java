package org.example.dao;
import java.util.List;
import org.example.base.Student;
import org.example.base.;

public interface StudentDAO {
    void addStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int id);

    void enrollCourse(int studentId, Course course);
    void assignMark(int studentId, int courseId, double mark);
    List<Course> getStudentCourses(int studentId);
    List<Marks> getStudentMarks(int studentId);
}
