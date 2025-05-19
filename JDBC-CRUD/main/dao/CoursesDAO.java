package dao;
import java.util.List;

public interface CoursesDAO {
    void addCourse(Course course);
    Course getCourseById(int id);
    List<Course> getAllCourses();
    void updateCourse(Course course);
    void deleteCourse(int id);
}
