/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfu.project.service.auth;

import kfu.project.entity.User;
import kfu.project.entity.UserToken;
import kfu.project.service.exception.DeadAccessTokenException;
import kfu.project.service.exception.IncorrectLoginDataException;
import kfu.project.service.exception.IncorrectRegistrationFormException;
import kfu.project.service.exception.UserWithSameEmailAlreadyExistsException;
import kfu.project.service.form.LoginForm;
import kfu.project.service.form.RegistrationForm;
import org.springframework.stereotype.Service;


@Service
public interface AuthService {

    UserToken registration(RegistrationForm registrationForm) throws  UserWithSameEmailAlreadyExistsException;

    boolean isAccessTokenActive(String accessToken);

    User getUserByAccessToken(String accessToken) throws DeadAccessTokenException;

    UserToken getToken(String refreshToken) throws DeadAccessTokenException;

    UserToken getToken(LoginForm loginForm) throws IncorrectLoginDataException;

   }
