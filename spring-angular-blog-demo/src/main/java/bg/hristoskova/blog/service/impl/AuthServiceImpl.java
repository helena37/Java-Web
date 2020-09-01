package bg.hristoskova.blog.service.impl;

import bg.hristoskova.blog.model.User;
import bg.hristoskova.blog.model.binding.RegisterRequest;
import bg.hristoskova.blog.repository.UserRepository;
import bg.hristoskova.blog.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        this.userRepository.save(user);
    }
}
