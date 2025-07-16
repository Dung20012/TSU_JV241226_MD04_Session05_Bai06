package com.data.session_05.repository;

import com.data.session_05.model.Student;
import com.data.session_05.utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "select * from students";
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setStudentName(rs.getString("student_name"));
                student.setEmail(rs.getString("email"));
                student.setBirthday(rs.getString("birthday"));
                student.setAvgMark(rs.getDouble("avg_mark"));
                students.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }

    public void addStudent(Student student){
        String sql = "insert into students (student_name,email,birthday,avg_mark) values (?,?,?,?)";
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getStudentName());
            stmt.setString(2, student.getEmail());
            stmt.setDate(3, Date.valueOf(student.getBirthday())); // yêu cầu birthday kiểu yyyy-MM-dd
            stmt.setDouble(4, student.getAvgMark());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Student findById(int id){
        String sql = "select * from students where id = ?";
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Student(
                        rs.getInt("id"),
                        rs.getString("student_name"),
                        rs.getString("email"),
                        rs.getString("birthday"),
                        rs.getDouble("avg_mark")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateStudent(Student student){
        String sql = "update students set student_name=?, email=?, birthday=?, avg_mark=? WHERE id=?";
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getStudentName());
            stmt.setString(2, student.getEmail());
            stmt.setDate(3, Date.valueOf(student.getBirthday()));
            stmt.setDouble(4, student.getAvgMark());
            stmt.setInt(5, student.getId());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id){
        String sql = "delete from students where id = ?";
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Student> searchAndSort(String keyword, String sortOrder){
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE student_name LIKE ? OR email LIKE ? ORDER BY id " + ("desc".equalsIgnoreCase(sortOrder) ? "DESC" : "ASC");
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setStudentName(rs.getString("student_name"));
                student.setEmail(rs.getString("email"));
                student.setBirthday(rs.getString("birthday"));
                student.setAvgMark(rs.getDouble("avg_mark"));
                students.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }
}
