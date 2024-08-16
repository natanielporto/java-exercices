package last_project.domain.model;

import jakarta.persistence.Entity;

import java.util.List;

@Entity(name = "tb_student")
public class Student extends User {
    private List<Course> enrolledCourses;
    private List<StudentProgress> progress;

    public Student(Long id, String name, String email, List<Course> enrolledCourses, List<StudentProgress> progress) {
        super(id, name, email);
        this.enrolledCourses = enrolledCourses;
        this.progress = progress;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public List<StudentProgress> getProgress() {
        return progress;
    }

    public void setProgress(List<StudentProgress> progress) {
        this.progress = progress;
    }
}

