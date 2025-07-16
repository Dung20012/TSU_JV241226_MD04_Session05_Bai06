package com.data.session_05.service;

import com.data.session_05.model.Student;
import com.data.session_05.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository repository = new StudentRepository();
    public List<Student> getAllStudents(){
        return  repository.getAllStudents();
    }

    public void addStudent(Student student){
        repository.addStudent(student);
    }

    public Student findById(int id){
        return repository.findById(id);
    }

    public void updateStudent(Student student){
        repository.updateStudent(student);
    }

    public void deleteStudent(int id){
        repository.deleteStudent(id);
    }

    public List<Student> searchAndSortStudents(String keyword, String sortOrder){
        if (keyword == null) keyword = "";
        return repository.searchAndSort(keyword, sortOrder);
    }
}
