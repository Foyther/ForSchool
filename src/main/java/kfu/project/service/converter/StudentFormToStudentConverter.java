package kfu.project.service.converter;

import kfu.project.service.form.StudentForm;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Nurislam on 19.07.2018.
 */
public interface StudentFormToStudentConverter extends Converter<StudentForm, Long>{
}
