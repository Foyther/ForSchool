package kfu.project.service.form;

/**
 * Created by Nurislam on 18.07.2018.
 */
public class TestAnswerForm {
    private String text;
    private boolean correct;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
