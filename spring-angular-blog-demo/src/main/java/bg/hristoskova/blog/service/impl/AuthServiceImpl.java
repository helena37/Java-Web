package bg.hristoskova.blog.service.impl;

import bg.hristoskova.blog.model.User;
import bg.hristoskova.blog.model.binding.AuthenticationResponse;
import bg.hristoskova.blog.model.binding.LoginRequest;
import bg.hristoskova.blog.model.binding.RegisterRequest;
import bg.hristoskova.blog.repository.UserRepository;
import bg.hristoskova.blog.security.JwtProvider;
import bg.hristoskova.blog.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void register(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        this.userRepository.save(user);
    }

   public AuthenticationResponse login(LoginRequest loginRequest) {
       Authentication authenticate =
               this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                       loginRequest.getUsername(),
                       loginRequest.getPassword()));
       SecurityContextHolder.getContext().setAuthentication(authenticate);
       String authenticationToken = this.jwtProvider.generateToken(authenticate);

       return new AuthenticationResponse(authenticationToken, loginRequest.getUsername());
   }

    @Override
    public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder
                        .getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }

    private String encodePassword(String password) {
        return this.passwordEncoder.encode(password);
    }
}
