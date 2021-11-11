package bg.hristoskova.judge1.service.impl;

import bg.hristoskova.judge1.model.entity.User;
import bg.hristoskova.judge1.model.service.UserServiceModel;
import bg.hristoskova.judge1.repository.UserRepository;
import bg.hristoskova.judge1.service.RoleService;
import bg.hristoskova.judge1.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @author helena81
 * @version 1.0
 * @since 9.11.21
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        userServiceModel.setRole(this.roleService.findByName(this.userRepository.count() == 0 ? "ADMIN" : "USER"));
        User user = this.modelMapper.map(userServiceModel, User.class);

        return this.modelMapper.map(this.userRepository.saveAndFlush(user),
                UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
