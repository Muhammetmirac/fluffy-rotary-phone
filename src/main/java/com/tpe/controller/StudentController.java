package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller// http://127.0.0.1:8080/students/1 ----> örneğin 1 id li student i getir diyoruz
@RequestMapping("/students") // students endpointi ile gelen requestler için bu sınıfa bakılacağını belirtiyorum
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/hi")// students/hi şeklini alıyor
    public ModelAndView sayHi() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Merhaba"); // key value şeklinde çalışır
        mav.addObject("messagebody", "Ben Bir Ögrenci Yönetim Sistemiyim");
        mav.setViewName("hi"); // resources altındaki hangi jsp sayafasında olduğunu belirtmiş olduk--> hi.jsp
        return mav;
    }

    @GetMapping("/new") // students/new şeklinde gelen endpoint buraya girecek
    public String sendStudentForm(@ModelAttribute("student") Student student) {
        return "studentForm";   // (@ModelAttribute ile Model e student isminde bir attibute ekledik

    }

    @PostMapping("/saveStudent") // students/saveStudents olarak geliyorsa
    public String createStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping
    public ModelAndView getStudents(){
     List<Student> list = studentService.getAllStudent();
     ModelAndView mav = new ModelAndView();
     mav.addObject("students",list);
     mav.setViewName("students");
     return mav;
    }
    //https://localhost:8080/springmvc/students/update?id=1 bu urlde 1 id li öğrenciyi update etmiş olacağız
    @GetMapping("/update") // update yapacağımız web sayfasını önümüze getirecek method
    public String showFormForUpdate(@RequestParam("id") Long id, Model model){
      Student student =  studentService.findStudentById(id);
        model.addAttribute(student);
        return "studentForm"; // studentForm.jsp sayfasını client tarafına gönderiyprum
    }

    //https://localhost:8080/springmvc/students/delete/1
    //burada @pathVariable kullanarak üst satırdaki gibi de kullanabiliriz
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
