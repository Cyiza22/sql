package org.example;

import org.example.base.Student;
import org.example.base.Course;
import org.example.base.Mark;
import org.example.db.DatabaseConnection;
import org.example.repositories.StudentRepository;
import org.example.repositories.CourseRepository;
import org.example.repositories.MarkRepository;
import java.sql.Connection;
import java.sql.Date;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static StudentRepository studentRepo;
    static CourseRepository courseRepo;
    static MarkRepository markRepo;

    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();


            studentRepo = new StudentRepository(connection);
            courseRepo = new CourseRepository(connection);
            markRepo = new MarkRepository(connection);

            while (true) {
                System.out.println("\nMENU");
                System.out.println("a. Add Student");
                System.out.println("b. View Students");
                System.out.println("c. Update Student");
                System.out.println("d. Delete Student");

                System.out.println("e. Add Course");
                System.out.println("f. View Courses");
                System.out.println("g. Update Course");
                System.out.println("h. Delete Course");

                System.out.println("i. Add Mark");
                System.out.println("j. View Marks");
                System.out.println("k. Update Mark");
                System.out.println("l. Delete Mark");

                System.out.println("n. Exit");

                String choice = sc.nextLine();
                switch (choice) {
                    case "a" -> addStudent();
                    case "b" -> viewStudents();
                    case "c" -> updateStudent();
                    case "d" -> deleteStudent();

                    case "e" -> addCourse();
                    case "f" -> viewCourses();
                    case "g" -> updateCourse();
                    case "h" -> deleteCourse();

                    case "i" -> addMark();
                    case "j" -> viewMarks();
                    case "k" -> updateMark();
                    case "l" -> deleteMark();

                    case "n" -> System.exit(0);
                    default -> System.out.println("Invalid option.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //STUDENTS
    static void addStudent() {
        System.out.print("First name: ");
        String fname = sc.nextLine();
        System.out.print("Last name: ");
        String lname = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Date of Birth (YYYY-MM-DD): ");
        Date dob = Date.valueOf(sc.nextLine());

        Student student = new Student(fname, lname, email, dob);
        studentRepo.create(student);
        System.out.println("Student added!");
    }

    static void viewStudents() {
        for (Student s : studentRepo.findAll()) {
            System.out.println(s);
        }
    }

    static void updateStudent() {
        System.out.print("Student ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        Student existing = studentRepo.findById(id);
        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("New first name [" + existing.firstName + "]: ");
        String fname = sc.nextLine();
        System.out.print("New last name [" + existing.lastName + "]: ");
        String lname = sc.nextLine();
        System.out.print("New email [" + existing.email + "]: ");
        String email = sc.nextLine();
        System.out.print("New DOB (YYYY-MM-DD) [" + existing.dateOfBirth + "]: ");
        String dobInput = sc.nextLine();

        Student updated = new Student(
                fname.isEmpty() ? existing.firstName : fname,
                lname.isEmpty() ? existing.lastName : lname,
                email.isEmpty() ? existing.email : email,
                dobInput.isEmpty() ? existing.dateOfBirth : Date.valueOf(dobInput)
        );

        studentRepo.update(updated, id);
        System.out.println("Student updated!");
    }

    static void deleteStudent() {
        System.out.print("Student ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        studentRepo.deleteById(id);
        System.out.println("Student deleted.");
    }

    //  COURSES
    static void addCourse() {
        System.out.print("Course name: ");
        String name = sc.nextLine();
        System.out.print("Course description: ");
        String description = sc.nextLine();

        Course course = new Course( name, description);
        courseRepo.create(course);
        System.out.println("Course added!");
    }

    static void viewCourses() {
        for (Course c : courseRepo.findAll()) {
            System.out.println(c);
        }
    }

    static void updateCourse() {
        System.out.print("Course ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        Course existing = courseRepo.findById(id);
        if (existing == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.print("New course name [" + existing.getCourseName() + "]: ");
        String name = sc.nextLine();
        System.out.print("New description [" + existing.getCourseDescription() + "]: ");
        String desc = sc.nextLine();

        Course updated = new Course(
                id,
                name.isEmpty() ? existing.getCourseName() : name,
                desc.isEmpty() ? existing.getCourseDescription() : desc
        );

        courseRepo.update(updated, id);
        System.out.println("Course updated!");
    }

    static void deleteCourse() {
        System.out.print("Course ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        courseRepo.deleteById(id);
        System.out.println("Course deleted.");
    }

    // ==== MARKS ====
    static void addMark() {
        System.out.print("Student ID: ");
        int studentId = Integer.parseInt(sc.nextLine());
        System.out.print("Course ID: ");
        int courseId = Integer.parseInt(sc.nextLine());
        System.out.print("Mark value: ");
        float value = Float.parseFloat(sc.nextLine());

        Mark mark = new Mark(studentId, courseId, value);
        markRepo.create(mark);
        System.out.println("Mark added!");
    }

    static void viewMarks() {
        for (Mark m : markRepo.findAll()) {
            System.out.println(m);
        }
    }

    static void updateMark() {
        System.out.print("Mark ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        Mark existing = markRepo.findById(id);
        if (existing == null) {
            System.out.println("Mark not found.");
            return;
        }

        System.out.print("New mark value [" + existing.getScore() + "]: ");
        String valueInput = sc.nextLine();

        double newValue = valueInput.isEmpty() ? existing.getScore() : Double.parseDouble(valueInput);
        Mark updated = new Mark(existing.getCourseId(), existing.getStudentId(), newValue);
        markRepo.update(updated, id);
        System.out.println("Mark updated!");
    }

    static void deleteMark() {
        System.out.print("Mark ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        markRepo.deleteById(id);
        System.out.println("Mark deleted.");
    }
}
