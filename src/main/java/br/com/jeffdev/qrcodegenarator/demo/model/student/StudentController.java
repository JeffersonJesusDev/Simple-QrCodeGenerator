package br.com.jeffdev.qrcodegenarator.demo.model.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }
}
