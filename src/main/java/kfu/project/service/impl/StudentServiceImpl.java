package kfu.project.service.impl;

import kfu.project.entity.Group;
import kfu.project.entity.Student;
import kfu.project.entity.Teacher;
import kfu.project.entity.User;
import kfu.project.repository.GroupRepository;
import kfu.project.repository.StudentRepository;
import kfu.project.repository.TeacherRepository;
import kfu.project.repository.UserRepository;
import kfu.project.service.exception.NotFound.UserNotFoundException;
import kfu.project.service.form.GroupShortForm;
import kfu.project.service.intrface.StudentService;
import kfu.project.service.response.StudentShortResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nurislam on 19.07.2018.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Student findOneById(Long id){
        if(id != null){
            return null;
        }
        Student student = studentRepository.findOne(id);
        return student;
    }

    @Override
    public Set<Student> findAllByGroup(GroupShortForm form, String token) throws UserNotFoundException {
        User user = userRepository.findOneByToken(token);
        Teacher teacher = teacherRepository.getByUser(user);
        if(teacher == null){
            throw new UserNotFoundException();
        }
        Set<Student> students = studentRepository.findAllByGroup(groupRepository.findOne(form.getId()));
        return students;
    }


}

