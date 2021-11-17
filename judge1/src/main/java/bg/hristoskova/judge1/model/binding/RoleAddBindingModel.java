package bg.hristoskova.judge1.model.binding;

/**
 * @author helena81
 * @version 1.0
 * @since 17.11.21
 */
public class RoleAddBindingModel {
    private String username;
    private String role;

    public RoleAddBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
