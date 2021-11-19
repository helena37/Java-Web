package bg.hristoskova.judge1.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * @author helena81
 * @version 1.0
 * @since 17.11.21
 */
public class HomeworkAddBindingModel {
    private String exercise;
    private String gitAddress;

    public HomeworkAddBindingModel() {
    }

    @Length(min = 3, message = "Exercise name must be at least 3 characters!")
    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+", message = "Enter, valid gitHub address!")
    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }
}
