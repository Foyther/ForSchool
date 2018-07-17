package kfu.project.repository;

import kfu.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Nurislam on 17.07.2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByEmailAndPasswordCrypt(String email, String passwordCrypt);

    User findOneByEmail(String email);

    User findOneById(Long id);

    @Query(value = "SELECT * from users WHERE id = (select user_tokens.user_id from user_tokens WHERE access_token = ?1)",nativeQuery = true)
    User findOneByToken(String token);
}
