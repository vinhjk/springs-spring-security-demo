package hivetech.demo.spring.controller;

import hivetech.demo.spring.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(0, "James Bond"),
            new Student(1, "Maria Jones"),
            new Student(2, "Anna Smith")
    );

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student" + studentId + "does not exists"));
    }
}
