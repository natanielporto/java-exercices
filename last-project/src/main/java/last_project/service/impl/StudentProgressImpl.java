package last_project.service.impl;

import last_project.domain.model.StudentProgress;
import last_project.domain.repository.StudentProgressRepository;
import last_project.service.StudentProgressService;
import last_project.service.exception.StudentProgressNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentProgressImpl implements StudentProgressService {
    @Autowired
    private StudentProgressRepository studentProgressRepository;

    @Override
    public StudentProgress createStudentProgress(StudentProgress studentProgress) {
        return studentProgressRepository.save(studentProgress);
    }

    @Override
    public StudentProgress updateStudentProgress(StudentProgress studentProgress) {
        Optional<StudentProgress> existingProgress = studentProgressRepository.findById(studentProgress.getStudent().getId());
        if(existingProgress.isPresent()) {
            return studentProgressRepository.save(studentProgress);
        } else {
            throw new StudentProgressNotFoundException("Progresso do estudante não encontrado");
        }
    }

    @Override
    public StudentProgress getStudentProgressByCourseAndStudent(Long courseId, Long studentId) {
        return studentProgressRepository.findByCourseIdAndStudentId(courseId, studentId)
                .orElseThrow(() -> new StudentProgressNotFoundException("Progresso do estudante não encontrado."));
    }

    @Override
    public List<StudentProgress> getAllStudentProgress() {
        return studentProgressRepository.findAll();
    }

    @Override
    public void deleteStudentProgress(Long id) {
        if(studentProgressRepository.existsById(id)) {
            studentProgressRepository.deleteById(id);
        } else {
            throw new StudentProgressNotFoundException("Progresso do estudante não encontrado.");
        }
    }
}
