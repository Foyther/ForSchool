package kfu.project.service.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import kfu.project.entity.Question;
import kfu.project.entity.Teacher;
import kfu.project.entity.Test;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Nurislam on 18.07.2018.
 */
public class TaskForm {

    private String name;

    @JsonProperty(value = "teacher_token")
    private String teacher;

    private Set<TestForm> tests;

    private Set<QuestionForm> questions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TestForm> getTests() {
        return tests;
    }

    public void setTests(Set<TestForm> tests) {
        this.tests = tests;
    }

    public Set<QuestionForm> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionForm> questions) {
        this.questions = questions;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
