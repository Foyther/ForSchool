package kfu.project.service.converter;

import kfu.project.entity.TestAnswer;
import kfu.project.service.form.TestAnswerForm;
import kfu.project.service.form.TestForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Nurislam on 18.07.2018.
 */

public interface TestAnswerFormToTestAnswerConverter extends Converter<TestAnswerForm, TestAnswer> {



}
