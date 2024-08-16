package last_project.service.impl;

import last_project.domain.model.Course;
import last_project.domain.repository.CourseRepository;
import last_project.service.CourseService;
import last_project.service.exception.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAllCourses() {
        try {
            return courseRepository.findAll();
        } catch (Exception e) {
            logger.error("Erro ao buscar todos os cursos", e);
            throw new RuntimeException("Erro ao buscar todos os cursos.", e);
        }
    }

    @Override
    public Course findCourseById(Long id) {
        try {
            return courseRepository.findById(id)
                    .orElseThrow(() -> new CourseNotFoundException("Curso com ID " + id + " não encontrado."));
        } catch (CourseNotFoundException e) {
            logger.warn(e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Erro ao buscar curso por ID: " + id, e);
            throw new RuntimeException("Erro ao buscar curso por ID.", e);
        }
    }

    @Override
    @Transactional
    public Course createCourse(Course course) {
        try {
            return courseRepository.save(course);
        } catch (Exception e) {
            logger.error("Erro ao criar curso", e);
            throw new RuntimeException("Erro ao criar curso.", e);
        }
    }

    @Override
    @Transactional
    public Course updateCourse(Long id, Course courseDetails) {
        try {
            Course course = findCourseById(id);
            course.setTitle(courseDetails.getTitle());
            course.setDescription(courseDetails.getDescription());
            course.setInstructor(courseDetails.getInstructor());
            course.setLessons(courseDetails.getLessons());
            return courseRepository.save(course);
        } catch (CourseNotFoundException e) {
            logger.warn(e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Erro ao atualizar curso com ID: " + id, e);
            throw new RuntimeException("Erro ao atualizar curso.", e);
        }
    }

    @Override
    @Transactional
    public void deleteCourse(Long id) {
        try {
            if (!courseRepository.existsById(id)) {
                throw new CourseNotFoundException("Curso com ID " + id + " não encontrado.");
            }
            courseRepository.deleteById(id);
        } catch (CourseNotFoundException e) {
            logger.warn(e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Erro ao deletar curso com ID: " + id, e);
            throw new RuntimeException("Erro ao deletar curso.", e);
        }
    }
}
