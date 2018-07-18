package kfu.project.service.converter;

import kfu.project.entity.Question;
import kfu.project.service.form.QuestionForm;
import org.springframework.stereotype.Component;

/**
 * Created by Nurislam on 18.07.2018.
 */
@Component
public class QuestionFormToQuestionConverterImpl implements QuestionFormToQuestionConverter {
    @Override
    public Question convert(QuestionForm source) {
        if(source == null){
            return null;
        }
        Question question = new Question();
        question.setAnswer(source.getAnswer());
        question.setText(source.getText());
        question.setMark(source.getMark());
        question.setRecommendation(source.getRecommendation());
        return question;
    }
}
