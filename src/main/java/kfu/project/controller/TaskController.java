package kfu.project.controller;

import kfu.project.entity.Task;
import kfu.project.entity.User;
import kfu.project.entity.UserToken;
import kfu.project.service.converter.TaskFormToTaskConverter;
import kfu.project.service.exception.AccessDeniedException;
import kfu.project.service.exception.DeadAccessTokenException;
import kfu.project.service.exception.IncorrectLoginDataException;
import kfu.project.service.exception.NotFound.UserNotFoundException;
import kfu.project.service.form.LoginForm;
import kfu.project.service.form.StudentsForTaskFrom;
import kfu.project.service.form.TaskForm;
import kfu.project.service.form.TaskShortForm;
import kfu.project.service.intrface.TaskService;
import kfu.project.service.response.ApiResult;
import kfu.project.service.response.AuthResult;
import kfu.project.service.response.ErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @RequestMapping(value = "", method = RequestMethod.POST)
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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ApiResult add(@RequestHeader(name = "teacher_token") String token) {
        ApiResult result = new ApiResult(errorCodes.getSuccess());
        if (token != null) {
            Set<Task> tasks = taskService.getAllByTeacher(token);
            result.setBody(tasks);
        } else {
            result.setCode(errorCodes.getNotFound());
        }
        return result;
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ApiResult delete(@RequestHeader(name = "teacher_token") String token,
                            @RequestBody TaskShortForm form) throws AccessDeniedException {
        ApiResult result = new ApiResult(errorCodes.getSuccess());
        if (token != null && form != null) {
            taskService.deleteByIdAndToken(form.getId(), token);
        } else {
            result.setCode(errorCodes.getNotFound());
        }
        return result;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ApiResult addStudents(@RequestHeader(name = "teacher_token") String token,
                                 @RequestBody StudentsForTaskFrom form) throws AccessDeniedException {
        ApiResult result = new ApiResult(errorCodes.getSuccess());
        try {
            if (token != null && form != null) {

                taskService.addStudent(form);

            } else {
                result.setCode(errorCodes.getNotFound());
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            result.setCode(errorCodes.getNotFound());
        }
        return result;
    }
}
