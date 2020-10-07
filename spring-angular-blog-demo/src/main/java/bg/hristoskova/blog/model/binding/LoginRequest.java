package bg.hristoskova.blog.model.binding;

import javax.validation.constraints.NotNull;

public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest() {
    }

    @NotNull(message = "Username is a required field")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull(message = "Password is a required field")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
