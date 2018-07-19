package kfu.project.service.intrface;

import kfu.project.entity.Task;
import kfu.project.entity.Teacher;
import kfu.project.service.exception.AccessDeniedException;
import kfu.project.service.exception.NotFound.UserNotFoundException;
import kfu.project.service.form.StudentsForTaskFrom;
import kfu.project.service.form.TaskForm;

import java.util.Set;

/**
 * Created by Nurislam on 18.07.2018.
 */
public interface TaskService {

    public Task save(TaskForm taskForm) throws UserNotFoundException;

    public Set<Task> getAllByTeacher(String token);

    void deleteByIdAndToken(Long id, String token) throws AccessDeniedException;

    void addStudent(StudentsForTaskFrom taskFrom) throws AccessDeniedException, UserNotFoundException;
}
