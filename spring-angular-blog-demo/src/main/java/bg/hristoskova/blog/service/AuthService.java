package bg.hristoskova.blog.service;

import bg.hristoskova.blog.model.binding.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest registerRequest);
}
