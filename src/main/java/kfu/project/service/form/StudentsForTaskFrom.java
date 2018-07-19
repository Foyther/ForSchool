package kfu.project.service.form;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

/**
 * Created by Nurislam on 18.07.2018.
 */
public class StudentsForTaskFrom {


    @JsonProperty(value = "task_id")
    private Long id;

    @JsonProperty(value = "students")
    private Set<StudentForm> studentForms;

    public StudentsForTaskFrom() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<StudentForm> getStudentForms() {
        return studentForms;
    }

    public void setStudentForms(Set<StudentForm> studentForms) {
        this.studentForms = studentForms;
    }
}
