package kfu.project.repository;

import kfu.project.entity.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nurislam on 17.07.2018.
 */
@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, Long> {

    UserToken findOneByAccessToken(String accessToken);

    UserToken findOneByRefreshToken(String refreshToken);
}
