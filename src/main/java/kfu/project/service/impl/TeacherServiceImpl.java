package kfu.project.service.impl;

import kfu.project.entity.Teacher;
import kfu.project.entity.User;
import kfu.project.entity.UserToken;
import kfu.project.repository.TeacherRepository;
import kfu.project.repository.UserRepository;
import kfu.project.service.intrface.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Nurislam on 18.07.2018.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher getByToken(String token) {
        User user = userRepository.findOneByToken(token);
        Teacher teacher = teacherRepository.getByUser(user);
        return teacher;
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }
}
