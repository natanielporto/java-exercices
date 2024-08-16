package last_project.domain.model;

import java.util.List;

public class Instructor extends User {
    private List<Course> courses;

    public Instructor(Long id, String name, String email, List<Course> courses) {
        super(id, name, email);
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
