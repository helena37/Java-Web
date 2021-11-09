package bg.hristoskova.judge1.service;

import bg.hristoskova.judge1.model.service.UserServiceModel;

/**
 * @author helena81
 * @version 1.0
 * @since 9.11.21
 */
public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);
}
