package last_project.service.impl;

import last_project.domain.model.Instructor;
import last_project.domain.repository.InstructorRepository;
import last_project.service.InstructorService;
import last_project.service.exception.InstructorNotFoundException;
import last_project.service.exception.ServiceExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class InstructorServiceImpl implements InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public List<Instructor> findAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor findInstructorById(Long id) {
        if(id == null) {
            throw new InstructorNotFoundException("O ID do instrutor não pode ser nulo");
        }

        return instructorRepository.findById(id).orElseThrow(() -> new RuntimeException("Instrutor não encontrado."));
    }

    @Override
    public Instructor findInstructorByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InstructorNotFoundException("O nome do instrutor não pode ser nulo ou vazio.");
        }

        return instructorRepository.findByName(name);
    }

    @Override
    public Instructor createInstructor(Instructor instructor) {
        if (instructor == null || instructor.getName() == null || instructor.getEmail() == null) {
            throw new InstructorNotFoundException("Os detalhes do instrutor não podem ser nulos.");
        }

        if (instructorRepository.existsByEmail(instructor.getEmail())) {
            throw new InstructorNotFoundException("Já existe um instrutor com o email " + instructor.getEmail());
        }

        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructorDetails) {
        if (id == null || instructorDetails == null) {
            throw new InstructorNotFoundException("O ID do instrutor e os detalhes do estudante não podem ser nulos.");
        }

        Instructor instructor = findInstructorById(id);

        if (!Objects.equals(instructor.getEmail(), instructorDetails.getEmail()) &&
                instructorRepository.existsByEmail(instructorDetails.getEmail())) {
            throw new InstructorNotFoundException("Já existe um instrutor com o email " + instructorDetails.getEmail());
        }

        instructor.setName(instructorDetails.getName());
        instructor.setEmail(instructorDetails.getEmail());
        instructor.setCourses(instructorDetails.getCourses());
        return instructorRepository.save(instructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        if (id == null) {
            throw new InstructorNotFoundException("O ID do instrutor não pode ser nulo.");
        }

        Instructor instructor = findInstructorById(id);
        instructorRepository.delete(instructor);
    }
}
