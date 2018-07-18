package kfu.project.service.converter;

import kfu.project.entity.Question;
import kfu.project.entity.Task;
import kfu.project.entity.Test;
import kfu.project.service.form.QuestionForm;
import kfu.project.service.form.TaskForm;
import kfu.project.service.form.TestForm;
import kfu.project.service.intrface.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by Nurislam on 18.07.2018.
 */

public interface TaskFormToTaskConverter extends Converter<TaskForm, Task> {


}
