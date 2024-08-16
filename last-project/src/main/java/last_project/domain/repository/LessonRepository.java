package last_project.domain.repository;

import last_project.domain.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    Lesson findByTitle(String title);
}
