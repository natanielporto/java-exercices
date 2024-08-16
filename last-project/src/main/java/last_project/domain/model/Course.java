package last_project.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private Instructor instructor;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    public Course(Long id, String title, String description, Instructor instructor, List<Lesson> lessons) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.lessons = lessons;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
