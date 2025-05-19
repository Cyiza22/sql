package dao;
import java.util.*;

public class CoursesDAOImpl implements CoursesDAO {
    private Map<Integer, Course> courseMap = new HashMap<>();

    @Override
    public void addCourse(Course course) {
        courseMap.put(course.getId(), course);
    }

    @Override
    public Course getCourseById(int id) {
        return courseMap.get(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return new ArrayList<>(courseMap.values());
    }

    @Override
    public void updateCourse(Course course) {
        if (courseMap.containsKey(course.getId())) {
            courseMap.put(course.getId(), course);
        }
    }

    @Override
    public void deleteCourse(int id) {
        courseMap.remove(id);
    }
}
