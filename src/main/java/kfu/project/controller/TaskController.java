package kfu.project.controller;

import kfu.project.entity.Task;
import kfu.project.entity.User;
import kfu.project.entity.UserToken;
import kfu.project.service.converter.TaskFormToTaskConverter;
import kfu.project.service.exception.DeadAccessTokenException;
import kfu.project.service.exception.IncorrectLoginDataException;
import kfu.project.service.exception.NotFound.UserNotFoundException;
import kfu.project.service.form.LoginForm;
import kfu.project.service.form.TaskForm;
import kfu.project.service.intrface.TaskService;
import kfu.project.service.response.ApiResult;
import kfu.project.service.response.AuthResult;
import kfu.project.service.response.ErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nurislam on 18.07.2018.
 */
@RestController
@RequestMapping(path = "/api/task")
public class TaskController {


    @Autowired
    private ErrorCodes errorCodes;

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ApiResult getTasks(@RequestBody TaskForm taskForm) {
        ApiResult result = new ApiResult(errorCodes.getSuccess());
        try {
            if (taskForm != null) {
                taskService.save(taskForm);
            } else {
                result.setCode(errorCodes.getNotFound());
            }
        } catch (UserNotFoundException e) {
            result.setCode(errorCodes.getNotFound());
        }
        return result;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ApiResult add(@RequestBody TaskForm taskForm) {
        ApiResult result = new ApiResult(errorCodes.getSuccess());
        try {
            if (taskForm != null) {
                taskService.save(taskForm);
            } else {
                result.setCode(errorCodes.getNotFound());
            }
        } catch (UserNotFoundException e) {
            result.setCode(errorCodes.getNotFound());
        }
        return result;
    }
}
