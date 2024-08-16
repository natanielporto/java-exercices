package last_project.controller;

import last_project.domain.model.Lesson;
import last_project.service.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonController {
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    public ResponseEntity<List<Lesson>> findAllLessons() {
        var lessons = lessonService.findAllLessons();
        return ResponseEntity.ok(lessons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> findById(@PathVariable Long id) {
        var lesson = lessonService.findById(id);
        return ResponseEntity.ok(lesson);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Lesson> findByTitle(@PathVariable String title) {
        var lesson = lessonService.findByTitle(title);
        return ResponseEntity.ok(lesson);
    }
}
