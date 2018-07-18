package kfu.project.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nurislam on 18.07.2018.
 */
public class AuthResult {

    @JsonProperty(value = "user_id")
    private Long id;
    private String role;
    private String token;
    private String name;

    public AuthResult() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
