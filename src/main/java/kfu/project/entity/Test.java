package kfu.project.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Nurislam on 13.07.2018.
 */
@Entity
@Table(name = "tests")
public class Test extends BogoClass {

    @NotNull
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TestAnswer> answers;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Set<TestAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<TestAnswer> answers) {
        this.answers = answers;
    }
}
