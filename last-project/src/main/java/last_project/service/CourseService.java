package last_project.service;

import last_project.domain.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourses();
    Course findCourseById(Long id);
    Course createCourse(Course course);
    Course updateCourse(Long id, Course courseDetails);
    void deleteCourse(Long id);
}
