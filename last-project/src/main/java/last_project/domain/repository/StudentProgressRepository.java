package last_project.domain.repository;

import last_project.domain.model.StudentProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentProgressRepository extends JpaRepository<StudentProgress, Long> {
    Optional<StudentProgress> findByCourseIdAndStudentId(Long courseId, Long studentId);
}
