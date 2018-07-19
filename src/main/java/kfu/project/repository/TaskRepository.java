package kfu.project.repository;

import kfu.project.entity.Task;
import kfu.project.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by Nurislam on 18.07.2018.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    Set<Task> getAllByTeacher(Teacher teacher);

    Task findById(Long id);
}
