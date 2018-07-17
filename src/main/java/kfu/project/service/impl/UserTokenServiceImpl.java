package kfu.project.service.impl;

import kfu.project.entity.UserToken;
import kfu.project.repository.UserTokenRepository;
import kfu.project.service.exception.DeadAccessTokenException;
import kfu.project.service.exception.NotFound.UserNotFoundException;
import kfu.project.service.intrface.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Nurislam on 17.07.2018.
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {

    @Autowired
    UserTokenRepository userTokenRepository;

    @Override
    public UserToken getById(Long id) throws UserNotFoundException, DeadAccessTokenException {
        if (id == null) {
            throw new UserNotFoundException();
        }
        UserToken userToken = userTokenRepository.findOne(id);
        if (userToken != null) {
            return userToken;
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public UserToken getByAccessToken(String accessToken) throws UserNotFoundException, DeadAccessTokenException {
        if (accessToken == null) {
            throw new UserNotFoundException();
        }
        UserToken userToken = userTokenRepository.findOneByAccessToken(accessToken);
        if (userToken != null) {
            return userToken;
        } else {
            throw new UserNotFoundException();
        }
    }
}

