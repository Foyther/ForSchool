package kfu.project.service.intrface;

import kfu.project.entity.Teacher;
import kfu.project.service.exception.NotFound.UserNotFoundException;
import kfu.project.service.response.MyGroupResult;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Nurislam on 18.07.2018.
 */
@Service
public interface TeacherService {

    public Teacher getByToken(String token);

    void save(Teacher teacher);

    Set<MyGroupResult> getAllGroupsByToken(String token) throws UserNotFoundException;
}
