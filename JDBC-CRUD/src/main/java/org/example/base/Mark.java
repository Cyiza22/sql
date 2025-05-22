package org.example.base;


public class Mark {
    public int studentId;
    public int courseId;
    public double mark;

    public Mark(int studentId, int courseId, double mark) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.mark = mark;
    }



    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public double getScore() {
        return mark;
    }

    public void setScore(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Course ID: " + courseId + ", Mark: " + mark;
    }
}

