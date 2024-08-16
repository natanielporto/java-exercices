package last_project.service;

import last_project.domain.model.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> findAllLessons();
    Lesson findById(Long id);
    Lesson findByTitle(String title);
}
