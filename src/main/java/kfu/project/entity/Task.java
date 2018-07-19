package kfu.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Nurislam on 13.07.2018.
 */
@Entity
@Table(name = "tasks")
public class Task extends BogoClass {

    @NotNull
    private String name;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    @JsonIgnore
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Test> tests;

    @JsonIgnore
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Question> questions;

    @JsonIgnore
    @ManyToMany(mappedBy = "tasks", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Student> students;

    @JsonIgnore
    @ManyToMany(mappedBy = "tasks", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Student> pastedStudents;

    public Task() {
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }


    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Student> getPastedStudents() {
        return pastedStudents;
    }

    public void setPastedStudents(Set<Student> pastedStudents) {
        this.pastedStudents = pastedStudents;
    }
}
