package last_project.domain.repository;

import last_project.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String name);
    boolean existsByEmail(String email);
}
