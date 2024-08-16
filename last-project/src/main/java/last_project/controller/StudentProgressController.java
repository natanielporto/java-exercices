package last_project.controller;

import last_project.domain.model.StudentProgress;
import last_project.service.StudentProgressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-progress")
public class StudentProgressController {
    private final StudentProgressService studentProgressService;

    public StudentProgressController(StudentProgressService studentProgressService) {
        this.studentProgressService = studentProgressService;
    }

    @PostMapping
    public ResponseEntity<StudentProgress> createStudentProgress (@RequestBody StudentProgress studentProgress) {
        var createdProgress = studentProgressService.createStudentProgress(studentProgress);
        return ResponseEntity.ok(createdProgress);
    }

    @PatchMapping
    public ResponseEntity<StudentProgress> updateStudentProgress(@RequestBody StudentProgress updatedProgress) {
        var updatedStudentProgress = studentProgressService.updateStudentProgress(updatedProgress);
        return ResponseEntity.ok(updatedStudentProgress);
    }

    @GetMapping("/{studentId}/{courseId}")
    public ResponseEntity<StudentProgress> getStudentProgressByCourseAndStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        var studentProgress = studentProgressService.getStudentProgressByCourseAndStudent(courseId, studentId);
        return ResponseEntity.ok(studentProgress);
    }

    @GetMapping
    public ResponseEntity<List<StudentProgress>> getAllStudentProgress () {
        var studentProgress = studentProgressService.getAllStudentProgress();
        return ResponseEntity.ok(studentProgress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentProgress(@PathVariable Long id) {
        studentProgressService.deleteStudentProgress(id);
        return ResponseEntity.noContent().build();
    }
}
