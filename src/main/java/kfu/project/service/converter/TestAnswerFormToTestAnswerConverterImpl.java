package kfu.project.service.converter;

import kfu.project.entity.TestAnswer;
import kfu.project.service.form.TestAnswerForm;
import org.springframework.stereotype.Component;

/**
 * Created by Nurislam on 18.07.2018.
 */
@Component
public class TestAnswerFormToTestAnswerConverterImpl implements TestAnswerFormToTestAnswerConverter {

    @Override
    public TestAnswer convert(TestAnswerForm source) {
        if(source == null){
            return null;
        }
        TestAnswer answer = new TestAnswer();
        answer.setCorrect(source.isCorrect());
        answer.setText(source.getText());
        return answer;
    }
}
