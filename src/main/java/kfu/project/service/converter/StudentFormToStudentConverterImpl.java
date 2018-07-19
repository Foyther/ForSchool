package kfu.project.service.converter;

import kfu.project.service.form.StudentForm;
import kfu.project.service.intrface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Nurislam on 19.07.2018.
 */
public class StudentFormToStudentConverterImpl implements  StudentFormToStudentConverter{
    @Autowired
    private StudentService studentService;

    @Override
    public Long convert(StudentForm source) {
        return null;
    }
}
