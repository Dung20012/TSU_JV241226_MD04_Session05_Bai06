package com.data.session_05.controller;

import com.data.session_05.model.Student;
import com.data.session_05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("")
    public ModelAndView listStudents(){
        List<Student> students = studentService.getAllStudents();
        ModelAndView mv = new ModelAndView("student-list");
        mv.addObject("students",students);
        return  mv;
    }

    @GetMapping("/add")
    public ModelAndView showStudent(){
        ModelAndView mv = new ModelAndView("student-add");
        mv.addObject("student",new Student());
        return mv;
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showStudent(@PathVariable int id){
        Student student = studentService.findById(id);
        ModelAndView mv = new ModelAndView("student-edit");
        mv.addObject("student",student);
        return mv;
    }

    @PostMapping("/edit/{id}")
    public String editStudent(@ModelAttribute("student")Student student){
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("")
    public ModelAndView listStudents(@RequestParam(required = false)String keyword,
                                     @RequestParam(required = false, defaultValue = "asc") String sort){
        List<Student> students = studentService.searchAndSortStudents(keyword, sort);
        ModelAndView mv = new ModelAndView("student-list");
        mv.addObject("students",students);
        mv.addObject("keyword",keyword);
        mv.addObject("sort",sort);
        return  mv;
    }
}
