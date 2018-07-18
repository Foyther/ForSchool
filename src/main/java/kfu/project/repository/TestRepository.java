package kfu.project.repository;

import kfu.project.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nurislam on 18.07.2018.
 */
@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}
