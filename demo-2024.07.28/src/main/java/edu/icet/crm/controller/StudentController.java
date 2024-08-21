package edu.icet.crm.controller;

import edu.icet.crm.model.Student;
import edu.icet.crm.service.StudentService;
import edu.icet.crm.service.StudentService2024;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/get-student")
    public Student getStd() {


        Student std = service.getStudent();
        System.out.println(std);

        return std;
    }



}
