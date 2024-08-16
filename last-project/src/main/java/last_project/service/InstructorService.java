package last_project.service;

import last_project.domain.model.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> findAllInstructors();
    Instructor findInstructorById(Long id);
    Instructor findInstructorByName(String name);
    Instructor createInstructor(Instructor instructor);
    Instructor updateInstructor(Long id, Instructor instructorDetails);
    void deleteInstructor(Long id);
}
