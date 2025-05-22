package org.example.base;


public class Course {
    public int id;
    public String name;
    public String description;

    public Course(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Course(String name, String description) {
        this(-1, name, description);
    }

    public int getCourseId() {
        return id;
    }

    public void setCourseId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return name;
    }

    public void setCourseName(String name) {
        this.name = name;
    }

    public String getCourseDescription() {
        return description;
    }

    public void setCourseDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return id + ": " + name + " - " + description;
    }
}

