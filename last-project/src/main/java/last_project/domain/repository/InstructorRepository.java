package last_project.domain.repository;

import last_project.domain.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Instructor findByName(String name);
    boolean existsByEmail(String email);
}
