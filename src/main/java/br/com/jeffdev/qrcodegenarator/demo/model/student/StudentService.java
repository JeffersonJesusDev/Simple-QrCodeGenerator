package br.com.jeffdev.qrcodegenarator.demo.model.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    //Lista para ter todos os estudantes
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //Adicionar os estudantes no banco
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    //Encontrar apenas um único estudante
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

}
