package kfu.project.service.converter;

import kfu.project.entity.Test;
import kfu.project.entity.TestAnswer;
import kfu.project.service.form.TestAnswerForm;
import kfu.project.service.form.TestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nurislam on 18.07.2018.
 */
@Component
public class TestFormToTestConverterImpl implements TestFormToTestConverter {

    @Autowired
    private TestAnswerFormToTestAnswerConverter testAnswerFormToTestAnswerConverter;
    @Override
    public Test convert(TestForm source) {
        if(source == null){
            return null;
        }
        Test test = new Test();
        Set<TestAnswer> answers = new HashSet<>();
        for(TestAnswerForm form: source.getAnswers()){
            TestAnswer temp = testAnswerFormToTestAnswerConverter.convert(form);
            temp.setTest(test);
            answers.add(temp);
        }
        test.setAnswers(answers);
        test.setText(source.getText());
        test.setMark(source.getMark());
        test.setRecommendation(source.getRecommendation());
        return test;
    }
}
