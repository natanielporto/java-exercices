package last_project.service.impl;

import last_project.domain.model.Lesson;
import last_project.domain.repository.LessonRepository;
import last_project.service.LessonService;
import last_project.service.exception.LessonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private static final Logger logger = LoggerFactory.getLogger(LessonServiceImpl.class);

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public List<Lesson> findAllLessons() {
        try {
            return lessonRepository.findAll();
        } catch (Exception e) {
            logger.error("Erro ao buscar todas as lições", e);
            throw new RuntimeException("Erro ao buscar todas as lições.", e);
        }
    }

    @Override
    public Lesson findById(Long id) {
        try {
            return lessonRepository.findById(id)
                    .orElseThrow(() -> new LessonNotFoundException("Lição com ID " + id + " não encontrada."));
        } catch (LessonNotFoundException e) {
            logger.warn(e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Erro ao buscar lição por ID: " + id, e);
            throw new RuntimeException("Erro ao buscar lição por ID.", e);
        }
    }

    @Override
    public Lesson findByTitle(String title) {
        try {
            Lesson lesson = lessonRepository.findByTitle(title);
            if (lesson == null) {
                throw new LessonNotFoundException("Lição com o título " + title + " não encontrada.");
            }
            return lesson;
        } catch (LessonNotFoundException e) {
            logger.warn(e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Erro ao buscar lição por título: " + title, e);
            throw new RuntimeException("Erro ao buscar lição por título.", e);
        }
    }
}
