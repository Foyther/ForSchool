package kfu.project.service.form;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * Created by Nurislam on 18.07.2018.
 */
public class QuestionForm {
    private String text;
    private String answer;

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
}
