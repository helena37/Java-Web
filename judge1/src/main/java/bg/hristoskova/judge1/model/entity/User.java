package bg.hristoskova.judge1.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author helena81
 * @version 1.0
 * @since 8.11.21
 */

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    private String password;
    private String email;
    private String git;
    private Role role;

    public User() {
    }

    @Column(name = "username", unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "github_address", nullable = false, unique = true)
    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    @ManyToOne
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
