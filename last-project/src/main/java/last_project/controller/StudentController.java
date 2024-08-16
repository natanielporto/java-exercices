package last_project.controller;

import last_project.domain.model.Student;
import last_project.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        var students = studentService.findAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentsById(@PathVariable Long id) {
        var student = studentService.findStudentById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Student> findInstructorByName(@PathVariable String name) {
        var student = studentService.findStudentByName(name);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student studentToCreate) {
        var studentCreated = studentService.createStudent(studentToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(studentCreated.getId()).toUri();
        return ResponseEntity.created(location).body(studentCreated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentToUpdate) {
        var studentUpdated = studentService.updateStudent(id, studentToUpdate);
        return ResponseEntity.ok(studentUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
