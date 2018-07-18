package kfu.project.repository;

import kfu.project.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nurislam on 18.07.2018.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

}
