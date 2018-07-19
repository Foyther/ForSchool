package kfu.project.repository;

import kfu.project.entity.Group;
import kfu.project.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by Nurislam on 19.07.2018.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    Set<Student> findAllByGroup(Group group);
}
