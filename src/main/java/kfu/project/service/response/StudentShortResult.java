package kfu.project.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nurislam on 19.07.2018.
 */
public class StudentShortResult {

    @JsonProperty(value = "student_id")
    private Long id;

    public StudentShortResult(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
