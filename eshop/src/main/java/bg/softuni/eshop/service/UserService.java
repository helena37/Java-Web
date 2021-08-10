package bg.softuni.eshop.service;

import bg.softuni.eshop.domain.entity.User;
import bg.softuni.eshop.domain.service.UserServiceModel;
import bg.softuni.eshop.service.impl.UserServiceImpl;


/**
 * @author helena81
 * @version 1.0
 * @since 7.08.21
 */
public interface UserService {
    UserServiceModel register(UserServiceModel userServiceModel);
}
