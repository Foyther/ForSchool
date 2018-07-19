package kfu.project.repository;

import kfu.project.entity.Teacher;
import kfu.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by Nurislam on 18.07.2018.
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    Teacher getByUser(User user);
}
