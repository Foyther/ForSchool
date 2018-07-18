package kfu.project.service.converter;

import kfu.project.entity.Question;
import kfu.project.entity.Task;
import kfu.project.entity.Test;
import kfu.project.entity.TestAnswer;
import kfu.project.service.form.QuestionForm;
import kfu.project.service.form.TaskForm;
import kfu.project.service.form.TestForm;
import kfu.project.service.intrface.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nurislam on 18.07.2018.
 */
@Component
public class TaskFormToTaskConverterImpl implements TaskFormToTaskConverter{

    @Autowired
    private QuestionFormToQuestionConverter converter;

    @Autowired
    private TestFormToTestConverter testFormToTestConverter;

    @Autowired
    private TeacherService teacherService;

    @Override
    public Task convert(TaskForm source) {
        if(source == null){
            return null;
        }
        Task task = new Task();
        task.setName(source.getName());
        task.setTeacher(teacherService.getByToken(source.getTeacher()));
        Set<Question> questions = new HashSet<>();
        for(QuestionForm form: source.getQuestions()){
            Question temp = converter.convert(form);
            temp.setTask(task);
            questions.add(temp);
        }
        task.setQuestions(questions);

        Set<Test> tests = new HashSet<>();
        for(TestForm form: source.getTests()){
            Test temp = testFormToTestConverter.convert(form);
            temp.setTask(task);
            tests.add(temp);
        }
        task.setTests(tests);
        return task;
    }
}
