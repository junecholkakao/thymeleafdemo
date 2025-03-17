package com.example.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.thymeleafdemo.model.Student;

@Controller
public class StudentController {
  @Value("${countries}")
  private List<String> countries;

  @Value("${languages}")
  private List<String> languages;

  @GetMapping("/showStudentForm")
  public String showForm(Model theModel) {
    // create a student object
    Student theStudent = new Student();

    // add student object to the model
    theModel.addAttribute("student", theStudent);

    theModel.addAttribute("countries", countries);

    theModel.addAttribute("languages", languages);

    return "student-form";
  }

  @PostMapping("/processStudentForm")
  public String processStudentForm(@ModelAttribute("student") Student theStudent) {
    // log the input data
    System.out.printf("theStudent: " + theStudent.getFirstName()+ " "+ theStudent.getLastName());
    System.out.printf("theStudent: " + theStudent.getCountry()+ " "+ theStudent.getFavoriteLanguage());
    return "student-confirmation";
  }
}

