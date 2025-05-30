package org.example.base;

import java.sql.Date;

public class Course {
    private int id;
    private String courseName;
    private String courseDescription;

    public Course(int id, String courseName, String courseDescription) {
        this.id = id;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }
    public Course(String CourseName, String courseDescription) {
        this(-1, CourseName ,courseDescription);
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + courseName + ": " + courseDescription;
    }
}
