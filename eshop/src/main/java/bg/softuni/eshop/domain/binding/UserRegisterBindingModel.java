package bg.softuni.eshop.domain.binding;

import bg.softuni.eshop.domain.BaseEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author helena81
 * @version 1.0
 * @since 7.08.21
 */
public class UserRegisterBindingModel {
    private String username;
    private String password;
    private String email;
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public UserRegisterBindingModel(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Length(min = 4, message = "Username must be at least 4 symbols")
    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 8, message = "Password should contains at least 8 symbols")
    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Email(message = "Please, enter valid email!")
    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
