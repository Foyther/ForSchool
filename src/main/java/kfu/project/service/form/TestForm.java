package kfu.project.service.form;

import kfu.project.entity.Task;
import kfu.project.entity.TestAnswer;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by Nurislam on 18.07.2018.
 */
public class TestForm {

    private Set<TestAnswerForm> answers;

    private String text;

    public Set<TestAnswerForm> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<TestAnswerForm> answers) {
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
