package kfu.project.service.intrface;

import kfu.project.entity.Student;
import kfu.project.service.exception.NotFound.UserNotFoundException;
import kfu.project.service.form.GroupShortForm;

import java.util.Set;

/**
 * Created by Nurislam on 19.07.2018.
 */
public interface StudentService {

    Student findOneById(Long id);

    Set<Student> findAllByGroup(GroupShortForm form, String token) throws UserNotFoundException;
}
