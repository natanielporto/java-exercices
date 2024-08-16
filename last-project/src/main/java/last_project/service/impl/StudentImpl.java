package last_project.service.impl;

import last_project.domain.model.Student;
import last_project.domain.repository.StudentRepository;
import last_project.service.StudentService;
import last_project.service.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class StudentImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Long id) {
        if(id == null) {
            throw new IllegalArgumentException("O ID do estudante não pode ser nulo");
        }

        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Estudante não encontrado."));
    }

    @Override
    public Student findStudentByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do estudante não pode ser nulo ou vazio.");
        }

        return studentRepository.findByName(name);
    }

    @Override
    public Student createStudent(Student student) {
        if (student == null || student.getName() == null || student.getEmail() == null) {
            throw new IllegalArgumentException("Os detalhes do estudante não podem ser nulos.");
        }

        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new IllegalArgumentException("Já existe um estudante com o email " + student.getEmail());
        }

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student studentDetails) {
        if (id == null || studentDetails == null) {
            throw new IllegalArgumentException("O ID do estudante e os detalhes do estudante não podem ser nulos.");
        }

        Student student = findStudentById(id);

        if (!Objects.equals(student.getEmail(), studentDetails.getEmail()) &&
                studentRepository.existsByEmail(studentDetails.getEmail())) {
            throw new IllegalArgumentException("Já existe um estudante com o email " + studentDetails.getEmail());
        }

        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setEnrolledCourses(studentDetails.getEnrolledCourses());
        return studentRepository.save(student);

    }

    @Override
    public void deleteStudent(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do estudante não pode ser nulo.");
        }

        Student student = findStudentById(id);
        studentRepository.delete(student);
    }
}
