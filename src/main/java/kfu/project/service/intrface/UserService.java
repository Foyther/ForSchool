package kfu.project.service.intrface;

import kfu.project.entity.User;
import kfu.project.service.exception.DeadAccessTokenException;
import kfu.project.service.exception.InvalidFormException;
import kfu.project.service.exception.NotFound.UserNotFoundException;

/**
 * Created by Nurislam on 17.07.2018.
 */
public interface UserService {
    User getById(Long id) throws UserNotFoundException;

    User getByAccessToken(String accessToken) throws DeadAccessTokenException, UserNotFoundException;

//    void editUser(String accessToken, EditProfileForm editProfileForm)
//            throws DeadAccessTokenException, UserNotFoundException, InvalidFormException;

    void save(User user) throws UserNotFoundException;
}
