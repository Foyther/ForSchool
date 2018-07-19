package kfu.project.service.impl;

import kfu.project.entity.*;
import kfu.project.repository.TeacherRepository;
import kfu.project.repository.UserRepository;
import kfu.project.service.exception.NotFound.UserNotFoundException;
import kfu.project.service.intrface.TeacherService;
import kfu.project.service.response.MyGroupResult;
import kfu.project.service.response.StudentShortResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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

    @Override
    public Set<MyGroupResult> getAllGroupsByToken(String token) throws UserNotFoundException {
        User user = userRepository.findOneByToken(token);
        Teacher teacher = teacherRepository.getByUser(user);
        if(teacher == null){
            throw new UserNotFoundException();
        }
        Set<MyGroupResult> results = new HashSet<>();
        for(Group group: teacher.getGroups()){
            MyGroupResult result = new MyGroupResult();
            result.setId(group.getId());
            result.setName(group.getName());
            Set<StudentShortResult> studentShortResults = new HashSet<>();
            for (Student student:group.getStudents()) {
                StudentShortResult studentShortResult = new StudentShortResult(student.getId());
                studentShortResult.setName(student.getUser().getName());
                studentShortResults.add(studentShortResult);
            }
            result.setResults(studentShortResults);
            results.add(result);
        }
        return results;
    }
}
