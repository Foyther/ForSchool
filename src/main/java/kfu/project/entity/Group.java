package kfu.project.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Nurislam on 18.07.2018.
 */
@Entity
@Table(name = "groups")
public class Group extends BogoClass{

    @NotNull
    private String name;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Student> students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teachers")
    private Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
