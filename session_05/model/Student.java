package com.data.session_05.model;

public class Student {
    private int id;
    private String studentName;
    private String email;
    private String birthday;
    private double avgMark;

    public Student() {
    }

    public Student(int id, String studentName, String email, String birthday, double avgMark) {
        this.id = id;
        this.studentName = studentName;
        this.email = email;
        this.birthday = birthday;
        this.avgMark = avgMark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(double avgMark) {
        this.avgMark = avgMark;
    }
}
