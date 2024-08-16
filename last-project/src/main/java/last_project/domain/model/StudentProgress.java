package last_project.domain.model;

public class StudentProgress {
    private Course course;
    private Student student;
    private int completedLessons;
    private boolean courseCompleted;

    public StudentProgress(Course course, Student student, int completedLessons, boolean courseCompleted) {
        this.course = course;
        this.student = student;
        this.completedLessons = completedLessons;
        this.courseCompleted = courseCompleted;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getCompletedLessons() {
        return completedLessons;
    }

    public void setCompletedLessons(int completedLessons) {
        this.completedLessons = completedLessons;
    }

    public boolean isCourseCompleted() {
        return courseCompleted;
    }

    public void setCourseCompleted(boolean courseCompleted) {
        this.courseCompleted = courseCompleted;
    }
}
