package kfu.project.service.response;

import java.util.Set;

/**
 * Created by Nurislam on 19.07.2018.
 */
public class MyGroupResult {
    private Long id;
    private String name;
    private Set<StudentShortResult> results;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StudentShortResult> getResults() {
        return results;
    }

    public void setResults(Set<StudentShortResult> results) {
        this.results = results;
    }
}
