package edu.icet.crm.service;

import edu.icet.crm.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService2024 implements StudentService {

    public Student getStudent(){

        Student student = new Student();

        student.setAge(20);
        student.setName("Sadew");
        student.setConNumber("0763730715");

        return student;
    }
}
