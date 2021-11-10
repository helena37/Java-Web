package bg.hristoskova.judge1.model.binding;

import org.hibernate.validator.constraints.Length;

/**
 * @author helena81
 * @version 1.0
 * @since 10.11.21
 */
public class UserLoginBindingModel {
    private String username;
    private String password;

    public UserLoginBindingModel() {
    }

    @Length(min = 2, max = 10, message = "Username must be at least 2 characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 2, max = 10, message = "Password must be at least 2 characters!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
