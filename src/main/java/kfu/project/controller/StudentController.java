package kfu.project.controller;

import kfu.project.entity.Student;
import kfu.project.service.exception.AccessDeniedException;
import kfu.project.service.exception.NotFound.UserNotFoundException;
import kfu.project.service.form.GroupShortForm;
import kfu.project.service.form.StudentsForTaskFrom;
import kfu.project.service.intrface.StudentService;
import kfu.project.service.intrface.TaskService;
import kfu.project.service.response.ApiResult;
import kfu.project.service.response.ErrorCodes;
import kfu.project.service.response.StudentShortResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nurislam on 19.07.2018.
 */
@RestController
@RequestMapping(path = "/api")
public class StudentController {

    @Autowired
    private ErrorCodes errorCodes;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ApiResult group(@RequestHeader(name = "teacher_token") String token,
                                 @RequestBody GroupShortForm form)  {
        ApiResult result = new ApiResult(errorCodes.getSuccess());
        try {
            if (token != null && form != null) {

                Set<Student> studentSet = studentService.findAllByGroup(form,token);
                result.setBody(getStudents(studentSet));
            } else {
                result.setCode(errorCodes.getNotFound());
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            result.setCode(errorCodes.getNotFound());
        }
        return result;
    }

    public Set<StudentShortResult> getStudents(Set<Student> students){
        Set<StudentShortResult> results = new HashSet<>();
        for(Student student: students){
            StudentShortResult temp = new StudentShortResult(student.getId());
            results.add(temp);
        }
        return results;
    }
}
