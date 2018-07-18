package kfu.project.service.converter;

import kfu.project.entity.Test;
import kfu.project.service.form.TestForm;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Nurislam on 18.07.2018.
 */
public interface TestFormToTestConverter extends Converter<TestForm,Test> {
}
