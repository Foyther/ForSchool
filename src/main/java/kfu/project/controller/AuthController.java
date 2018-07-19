package kfu.project.controller;

import kfu.project.entity.User;
import kfu.project.entity.UserToken;
import kfu.project.service.auth.AuthService;
import kfu.project.service.exception.DeadAccessTokenException;
import kfu.project.service.exception.IncorrectLoginDataException;
import kfu.project.service.exception.NotFound.UserNotFoundException;
import kfu.project.service.exception.UserWithSameEmailAlreadyExistsException;
import kfu.project.service.form.LoginForm;
import kfu.project.service.form.RegistrationForm;
import kfu.project.service.intrface.UserService;
import kfu.project.service.response.ApiResult;
import kfu.project.service.response.AuthResult;
import kfu.project.service.response.ErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Nurislam on 17.07.2018.
 */
@RestController
@RequestMapping(path = "api/")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ErrorCodes errorCodes;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public ApiResult login(@RequestBody LoginForm loginForm) {
        ApiResult result = new ApiResult(errorCodes.getSuccess());
        try {
            UserToken userToken = authService.getToken(loginForm);
            User user = userService.getByAccessToken(userToken.getAccessToken());
            if (userToken != null && user != null) {
//                result.setBody(user);
                AuthResult authResult = new AuthResult();
                authResult.setId(user.getId());
                authResult.setName(user.getName());
                authResult.setRole(user.getRole());
                authResult.setToken(userToken.getAccessToken());
                result.setBody(authResult);
            } else {
                result.setCode(errorCodes.getNotFound());
            }
        } catch (IncorrectLoginDataException ex) {
            result.setCode(errorCodes.getInvalidLoginOrPassword());
        } catch (UserNotFoundException e) {
            result.setCode(errorCodes.getNotFound());
        } catch (DeadAccessTokenException e) {
            result.setCode(errorCodes.getInvalidOrOldAccessToken());
        }

        return result;
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.GET)
    public ApiResult registration() {
        ApiResult result = new ApiResult(errorCodes.getSuccess());
        RegistrationForm teacher = new RegistrationForm("teacherCool@google.com", "12345678" ,"Teacher", User.TEACHER_ROLE );
        RegistrationForm student1 = new RegistrationForm("Vasya@google.com", "12345678" ,"Vasya", User.STUDENT_ROLE );
        RegistrationForm student2 = new RegistrationForm("Artem@google.com", "12345678" ,"Artem", User.STUDENT_ROLE);
        RegistrationForm admin = new RegistrationForm("admin@mail.ru", "12345678" ,"ADMEN", User.ADMIN_ROLE );
        result = save(teacher);
        result = save(student1);
        result = save(student2);
        result = save(admin);
        return result;
    }

    public ApiResult save(RegistrationForm form){
        ApiResult result = new ApiResult(errorCodes.getSuccess());
        try {
            UserToken token = authService.registration(form);
            if (token != null) {
                result.setBody(token);
            } else {
                result.setCode(errorCodes.getNotFound());
            }
        } catch (UserWithSameEmailAlreadyExistsException ex) {
            result.setCode(errorCodes.getUserWithSameLoginAlreadyExists());
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
