package org.example;
import dao.StudentDAO;

public class Main {
    public static void main(String[] args) {
        // DAOs
        StudentDAO studentDAO = new StudentDAOImpl();
        CoursesDAO courseDAO = new CoursesDAOImpl();
        MarksDAO marksDAO = new MarksDAOImpl();

        // Students
        Student s1 = new Student(1, "Alice", "alice@example.com");
        Student s2 = new Student(2, "Bob", "bob@example.com");
        studentDAO.addStudent(s1);
        studentDAO.addStudent(s2);

        // Courses
        Course math = new Course(101, "Math", "Algebra and Geometry");
        Course science = new Course(102, "Science", "Physics and Chemistry");
        courseDAO.addCourse(math);
        courseDAO.addCourse(science);

        // Enroll students (using StudentDAO)
        studentDAO.enrollCourse(1, math);
        studentDAO.enrollCourse(1, science);
        studentDAO.enrollCourse(2, math);

        // Assign marks (use MarksDAO)
        marksDAO.addMark(new Marks(1, 101, 88.5));
        marksDAO.addMark(new Marks(1, 102, 91.0));
        marksDAO.addMark(new Marks(2, 101, 76.0));

        // Display
        System.out.println("=== Student Info ===");
        for (Student student : studentDAO.getAllStudents()) {
            System.out.println(student);

            System.out.println(" Enrolled Courses:");
            for (Course c : studentDAO.getStudentCourses(student.getId())) {
                System.out.println("  - " + c);
            }

            System.out.println(" Marks:");
            for (Marks m : marksDAO.getMarksByStudentId(student.getId())) {
                Course relatedCourse = courseDAO.getCourseById(m.getCourse_id());
                System.out.println("  - " + relatedCourse.getCourse_name() + ": " + m.getMarks());
            }

            System.out.println();
        }
    }
}
