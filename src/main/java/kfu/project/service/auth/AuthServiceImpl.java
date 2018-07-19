/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kfu.project.service.auth;


import kfu.project.entity.*;
import kfu.project.repository.*;
import kfu.project.service.Crypter;
import kfu.project.service.TokenGenerator;
import kfu.project.service.exception.DeadAccessTokenException;
import kfu.project.service.exception.IncorrectLoginDataException;
import kfu.project.service.exception.IncorrectRegistrationFormException;
import kfu.project.service.exception.UserWithSameEmailAlreadyExistsException;
import kfu.project.service.form.LoginForm;
import kfu.project.service.form.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserTokenRepository userTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private Crypter crypter;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AdminRepository adminRepository;


    private long accessTokenLifeTime;

    public AuthServiceImpl(long accessTokenLifeTime) {
        this.accessTokenLifeTime = accessTokenLifeTime;
    }

    @Override
    public User getUserByAccessToken(String accessToken) throws DeadAccessTokenException {
        UserToken token = userTokenRepository.findOneByAccessToken(accessToken);
        if (token == null) {
            throw new DeadAccessTokenException("token doesn't exist");
        } else {
            if (token.getExpiresIn() < System.currentTimeMillis()) {
                throw new DeadAccessTokenException("token is old");
            } else {
                return token.getUser();
            }
        }
    }

    @Override
    public UserToken getToken(String refreshToken) throws DeadAccessTokenException {
        UserToken token = userTokenRepository.findOneByRefreshToken(refreshToken);
        if (token == null) {
            throw new DeadAccessTokenException("tokenNotFound");
        } else {
            refreshToken(token);
            return token;
        }
    }

    @Override
    public UserToken getToken(LoginForm loginForm) throws IncorrectLoginDataException {
        UserToken token = new UserToken();
            User user = userRepository.findOneByEmail(loginForm.getEmail());
            if (user != null) {
                token = user.getToken();
                if (token != null) {
                    refreshToken(token);
                    return token;
                } else {
                    token = generateToken(user);
                    return token;
                }
            }
            return token;
    }

    @Override
    public UserToken registration(RegistrationForm registrationForm) throws UserWithSameEmailAlreadyExistsException {
            User user = userRepository.findOneByEmail(registrationForm.getEmail());
            if (user != null) {
                throw new UserWithSameEmailAlreadyExistsException();
            } else {
                user = registrationForm.generateUser(crypter);
                user = userRepository.save(user);
                UserToken token = generateToken(user);
                switch (user.getRole()){
                    case User.TEACHER_ROLE:
                        Teacher teacher = new Teacher();
                        teacher.setUser(user);
                        teacherRepository.save(teacher);
                        break;
                    case User.STUDENT_ROLE:
                        Student student = new Student();
                        student.setUser(user);
                        studentRepository.save(student);
                        break;
                    case User.ADMIN_ROLE:
                        Admin admin = new Admin();
                        admin.setUser(user);
                        adminRepository.save(admin);
                        break;

                }
                return token;
            }
        }

    @Override
    public boolean isAccessTokenActive(String accessToken) {
        UserToken token = userTokenRepository.findOneByAccessToken(accessToken);
        if (token == null) {
            return false;
        } else {
            return token.getExpiresIn() > System.currentTimeMillis();
        }
    }

    private void refreshToken(UserToken token) {
        token.setAccessToken(tokenGenerator.generate());
        token.setRefreshToken(tokenGenerator.generate());
        token.setExpiresIn(System.currentTimeMillis() + accessTokenLifeTime);
        userTokenRepository.save(token);
    }

    private UserToken generateToken(User user) {
        UserToken token = new UserToken();
        token.setUser(user);
        token.setAccessToken(tokenGenerator.generate());
        token.setRefreshToken(tokenGenerator.generate());
        token.setExpiresIn(System.currentTimeMillis() + accessTokenLifeTime);
        token = userTokenRepository.save(token);
        return token;
    }

}
