package br.com.jeffdev.qrcodegenarator.demo.model.student;

import br.com.jeffdev.qrcodegenarator.demo.utils.QrCodeGenerator;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() throws IOException, WriterException {
        List<Student> students = studentService.getAllStudents();
        if (students.size() > 0) {
            for (Student student : students) {
                QrCodeGenerator.generateQRCode(student);
            }
        }
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
