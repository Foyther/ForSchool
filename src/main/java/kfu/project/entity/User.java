package kfu.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Nurislam on 09.07.2018.
 */
@Entity
@Table(name = "users")
public class User extends BogoClass{

    public static final String ADMIN_ROLE = "ADMIN";
    public static final String STUDENT_ROLE = "STUDENT";
    public static final String TEACHER_ROLE = "TEACHER";

    @NotNull
    @Column(
            name = "email",
            unique = true
    )
    private String email;

    @JsonIgnore
    @NotNull
    @Column(name = "password")
    private String passwordCrypt;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "role")
    private String role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserToken token;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Admin admin;
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Teacher teacher;
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Student student;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordCrypt() {
        return passwordCrypt;
    }

    public void setPasswordCrypt(String passwordCrypt) {
        this.passwordCrypt = passwordCrypt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserToken getToken() {
        return token;
    }

    public void setToken(UserToken token) {
        this.token = token;
    }

}
