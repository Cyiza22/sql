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
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Connection connection;

    static {
        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            System.out.println("There was an erroer" + e.getMessage());
        }
    }

    static StudentRepository studentRepo = new StudentRepository();
    CourseRepository courseRepo = new CourseRepository(connection);
    MarkRepository markRepo = new MarkRepository(connection);

    public static void main(String[] args) {
        Main mainApp = new Main(); // for non-static method access

        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("a. Add Student");
            System.out.println("b. View Students");
            System.out.println("c. Update Student");
            System.out.println("d. Delete Student");
            System.out.println("e. Add Course");
            System.out.println("f. View Courses");
            System.out.println("g. Delete Course");
            System.out.println("h. Add Mark");
            System.out.println("i. View Marks");
            System.out.println("j. Delete Mark");
            System.out.println("n. Exit");

            String choice = sc.nextLine();
            switch (choice) {
                case "a" -> addStudent();
                case "b" -> viewStudents();
                case "c" -> updateStudent();
                case "d" -> deleteStudent();
                case "e" -> mainApp.addCourse();
                case "f" -> mainApp.viewCourses();
                case "g" -> mainApp.deleteCourse();
                case "h" -> mainApp.addMark();
                case "i" -> mainApp.viewMarks();
                case "j" -> mainApp.deleteMark();
                case "n" -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }

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

    // ==== Course Methods ====

    void addCourse() {
        System.out.print("Course name: ");
        String name = sc.nextLine();
        System.out.print("Course code: ");
        String code = sc.nextLine();

        Course course = new Course(name, code);
        courseRepo.create(course);
        System.out.println("Course added!");
    }

    void viewCourses() {
        for (Course c : courseRepo.findAll()) {
            System.out.println(c);
        }
    }

    void deleteCourse() {
        System.out.print("Course ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        courseRepo.deleteById(id);
        System.out.println("Course deleted.");
    }

    // ==== Mark Methods ====

    void addMark() {
        System.out.print("Student ID: ");
        int studentId = Integer.parseInt(sc.nextLine());
        System.out.print("Course ID: ");
        int courseId = Integer.parseInt(sc.nextLine());
        System.out.print("Score: ");
        double score = Double.parseDouble(sc.nextLine());

        Mark Score = new Mark(studentId, courseId, score);
        markRepo.create(Score);
        System.out.println("Mark added!");
    }

    void viewMarks() {
        for (Mark m : markRepo.findAll()) {
            System.out.println(m);
        }
    }

    void deleteMark() {
        System.out.print("Mark ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        markRepo.deleteById(id);
        System.out.println("Mark deleted.");
    }
}
