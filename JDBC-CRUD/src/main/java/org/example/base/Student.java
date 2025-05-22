package org.example.base;


import java.sql.Date;

public class Student {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public Date dateOfBirth;

    public Student(int id, String firstName, String lastName, String email, Date dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dob;
    }

    public Student(String firstName, String lastName, String email, Date dob) {
        this(-1, firstName, lastName, email, dob);
    }


    @Override
    public String toString() {
        return id + ": " + firstName + " " + lastName + " (" + email + ") DOB: " + dateOfBirth;
    }
}
