package kfu.project.service.converter;

import kfu.project.entity.Question;
import kfu.project.service.form.QuestionForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Nurislam on 18.07.2018.
 */

public interface QuestionFormToQuestionConverter extends Converter<QuestionForm, Question> {

}
