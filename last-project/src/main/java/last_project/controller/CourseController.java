package last_project.controller;

import last_project.domain.model.Course;
import last_project.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public ResponseEntity<Course> findAllCourses() {
        var courses = courseService.findAllCourses();
        return ResponseEntity.ok((Course) courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable Long id) {
        var course = courseService.findCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course courseToCreate) {
        var courseCreated = courseService.createCourse(courseToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(courseCreated.getId()).toUri();
        return ResponseEntity.created(location).body(courseCreated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseToUpdate) {
        var courseUpdated = courseService.updateCourse(id, courseToUpdate);
        return ResponseEntity.ok(courseUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
