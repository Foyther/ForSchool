package kfu.project.service.intrface;

import kfu.project.entity.Teacher;
import kfu.project.entity.UserToken;
import org.springframework.stereotype.Service;

/**
 * Created by Nurislam on 18.07.2018.
 */
@Service
public interface TeacherService {

    public Teacher getByToken(String token);

    void save(Teacher teacher);
}
