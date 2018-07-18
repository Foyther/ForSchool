package kfu.project.service.intrface;

import kfu.project.entity.Task;
import kfu.project.service.exception.NotFound.UserNotFoundException;
import kfu.project.service.form.TaskForm;

/**
 * Created by Nurislam on 18.07.2018.
 */
public interface TaskService {

    public Task save(TaskForm taskForm) throws UserNotFoundException;
}
