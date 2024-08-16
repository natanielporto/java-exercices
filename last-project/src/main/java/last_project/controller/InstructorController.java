package last_project.controller;

import last_project.domain.model.Instructor;
import last_project.service.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> findAllInstructors() {
        var instructors = instructorService.findAllInstructors();
        return ResponseEntity.ok(instructors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable Long id) {
        var instructor = instructorService.findInstructorById(id);
        return ResponseEntity.ok(instructor);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Instructor> findInstructorByName(@PathVariable String name) {
        var instructor = instructorService.findInstructorByName(name);
        return ResponseEntity.ok(instructor);
    }

    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructorToCreate) {
        var instructorCreated = instructorService.createInstructor(instructorToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(instructorCreated.getId()).toUri();
        return ResponseEntity.created(location).body(instructorCreated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructorToUpdate) {
        var instructorUpdated = instructorService.updateInstructor(id, instructorToUpdate);
        return ResponseEntity.ok(instructorUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }
}
