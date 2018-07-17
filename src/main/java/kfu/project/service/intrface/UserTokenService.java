package kfu.project.service.intrface;

import kfu.project.entity.UserToken;
import kfu.project.service.exception.DeadAccessTokenException;
import kfu.project.service.exception.NotFound.UserNotFoundException;

/**
 * Created by Nurislam on 17.07.2018.
 */
public interface UserTokenService {
    UserToken getById(Long id) throws UserNotFoundException, DeadAccessTokenException;

    UserToken getByAccessToken(String accessToken) throws UserNotFoundException, DeadAccessTokenException;

}
