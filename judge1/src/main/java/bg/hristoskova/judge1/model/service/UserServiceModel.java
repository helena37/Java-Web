package bg.hristoskova.judge1.model.service;

import bg.hristoskova.judge1.model.entity.Role;

/**
 * @author helena81
 * @version 1.0
 * @since 9.11.21
 */
public class UserServiceModel extends BaseServiceModel {
    private String username;
    private String password;
    private String email;
    private String git;
    private RoleServiceModel role;


    public UserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public RoleServiceModel getRole() {
        return role;
    }

    public void setRole(RoleServiceModel role) {
        this.role = role;
    }
}
