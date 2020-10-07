package bg.hristoskova.blog.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterRequest {
    private String username;
    private String email;
    private String password;

    public RegisterRequest() {
    }

    @Length(min = 5, message = "Username should be at least 5 characters!")
    @NotNull(message = "Username is a required field")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 6, max = 16, message = "Password should contains between 6 and 16 characters!")
    @NotNull(message = "Password is a required field")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Email()
    @NotNull(message = "Email is a required field")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
