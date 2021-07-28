package bg.hristoskova.userservice.service;

import bg.hristoskova.userservice.domain.Role;
import bg.hristoskova.userservice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
