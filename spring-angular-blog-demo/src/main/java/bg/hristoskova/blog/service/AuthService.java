package bg.hristoskova.blog.service;

import bg.hristoskova.blog.model.binding.LoginRequest;
import bg.hristoskova.blog.model.binding.RegisterRequest;

import java.util.Optional;

public interface AuthService {
    void register(RegisterRequest registerRequest);
    String login(LoginRequest loginRequest);
    Optional<org.springframework.security.core.userdetails.User> getCurrentUser();
}
