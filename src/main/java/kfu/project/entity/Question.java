package kfu.project.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Nurislam on 13.07.2018.
 */
@Entity
@Table(name = "questions")
public class Question extends BogoClass {

    @NotNull
    @Column(name = "text")
    private String text;

    @NotNull
    @Column(name = "answer")
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<StudentAnswer> answers;

    public Question() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Set<StudentAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<StudentAnswer> answers) {
        this.answers = answers;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
