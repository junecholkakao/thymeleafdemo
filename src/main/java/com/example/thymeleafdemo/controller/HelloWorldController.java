package com.example.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
  // need a controller method to show initial HTML form

  @RequestMapping(path = "/form")
  public String requestMethodName(HttpServletRequest request, Model model) {
    String method = request.getMethod();
    System.out.println(method);

    if (method.equals("POST")) {
      System.out.println(method);
      String theName = request.getParameter("studentName");
      // convert the data to all caps
      theName = theName.toUpperCase();
      // create the message
      String result = "Yo! " + theName;

      // add message to the model
      model.addAttribute("message", result);
      return "helloworld";
    }
    return "helloworld-form";
  }

  @GetMapping("/showForm")
  public String showForm() {
    return "helloworld-form";
  }

  // need a controller method to process the HTML form
  @GetMapping("/processForm")
  public String processForm() {
    return "helloworld";
  }

  // need a controller method to read form data and
  // add data to the model
  @GetMapping("/processFormVersionTwo")
  public String letsShoutDude(HttpServletRequest request, Model model) {
    // read the request parameter form the HTML form
    String theName = request.getParameter("studentName");
    // convert the data to all caps
    theName = theName.toUpperCase();
    // create the message
    String result = "Yo! " + theName;

    // add message to the model
    model.addAttribute("message", result);
    return "helloworld";
  }

  @PostMapping("/processFormVersionThree")
  public String processFormVersionThree(
      @RequestParam("studentName") String theName,
      Model model) {

    // convert the data to all caps
    theName = theName.toUpperCase();
    // create the message
    String result = "Yo, Sneaky! " + theName;

    // add message to the model
    model.addAttribute("message", result);
    return "helloworld";
  }

}
