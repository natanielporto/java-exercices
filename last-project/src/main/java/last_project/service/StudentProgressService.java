package last_project.service;

import last_project.domain.model.StudentProgress;

import java.util.List;

public interface StudentProgressService {
    StudentProgress createStudentProgress(StudentProgress studentProgress);
    StudentProgress updateStudentProgress(StudentProgress studentProgress);
    StudentProgress getStudentProgressByCourseAndStudent(Long courseId, Long studentId);
    List<StudentProgress> getAllStudentProgress();
    void deleteStudentProgress(Long id);
}
