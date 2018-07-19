package kfu.project.service.form;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nurislam on 19.07.2018.
 */
public class StudentForm {

    @JsonProperty(value = "student_id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
