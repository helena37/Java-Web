package bg.hristoskova.judge1.model.service;

import bg.hristoskova.judge1.model.entity.Exercise;
import bg.hristoskova.judge1.model.entity.User;

import java.time.LocalDateTime;

/**
 * @author helena81
 * @version 1.0
 * @since 17.11.21
 */
public class HomeworkServiceModel extends BaseServiceModel{
    private LocalDateTime addedOn;
    private String gitAddress;
    private UserServiceModel author;
    private ExerciseServiceModel exercise;

    public HomeworkServiceModel() {
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }

    public UserServiceModel getAuthor() {
        return author;
    }

    public void setAuthor(UserServiceModel author) {
        this.author = author;
    }

    public ExerciseServiceModel getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseServiceModel exercise) {
        this.exercise = exercise;
    }
}
