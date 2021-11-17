package bg.hristoskova.judge1.model.view;

/**
 * @author helena81
 * @version 1.0
 * @since 17.11.21
 */
public class UserProfileViewModel {
    private String username;
    private String email;
    private String git;

    public UserProfileViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
