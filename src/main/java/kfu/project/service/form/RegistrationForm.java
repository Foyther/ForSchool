package kfu.project.service.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kfu.project.entity.User;
import kfu.project.service.Crypter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * Created by Nurislam on 17.07.2018.
 */
public class RegistrationForm {

    private String email;
    private String password;
    private String name;
    private String role;

    public RegistrationForm(String email, String password, String name, String role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public User generateUser(Crypter crypter) {
        User user = new User();
        user.setEmail(email);
        user.setPasswordCrypt(crypter.crypt(password));
        user.setName(name);
        user.setRole(role);
        return user;
    }
}
