package kfu.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Nurislam on 13.07.2018.
 */
@Entity
@Table(name = "students")
public class Student extends BogoClass {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groups")
    private Group group;

    @NotNull
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Task> tasks;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Task> passedTasks;

    public Student() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<Task> getPassedTasks() {
        return passedTasks;
    }

    public void setPassedTasks(Set<Task> passedTasks) {
        this.passedTasks = passedTasks;
    }
}
