package com.bib.student.controller;

import com.bib.student.entity.Student;
import com.bib.student.exception.ResourceNotFoundException;
import com.bib.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bibl")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    // get all student
    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    //create student
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // get student by
    @GetMapping("/students/{cin}")
    public ResponseEntity<Student> getStudentByCin(@PathVariable Integer cin){
        Student student = studentRepository.findById(cin)
                .orElseThrow(()-> new ResourceNotFoundException("Student not exist with cin:"+cin));
        return ResponseEntity.ok(student);
    }

    //update student
    @PutMapping("/students/update")
    public ResponseEntity<Student> updateStudent( @RequestBody Student studentDetails){
        Student student = studentRepository.findById(studentDetails.getCin())
                .orElseThrow(()-> new ResourceNotFoundException("Student not exist with cin:"+studentDetails.getCin()));
        student.setStudentFirstName(studentDetails.getStudentFirstName());
        student.setStudentLastName(studentDetails.getStudentLastName());
        student.setStudentMail(studentDetails.getStudentMail());
        student.setStudentPhone(studentDetails.getStudentPhone());
        Student updateStudent = studentRepository.save(student);
        return ResponseEntity.ok(updateStudent);
    }

    //delete student
    @DeleteMapping("/students/{cin}")
    public ResponseEntity<Map<String,Boolean>> deleteStudent(@PathVariable Integer cin){
        Student student = studentRepository.findById(cin).
                orElseThrow(()-> new ResourceNotFoundException("Student not exit with cin:"+cin));
        studentRepository.delete(student);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
