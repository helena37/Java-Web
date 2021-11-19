package bg.hristoskova.judge1.model.service;

import bg.hristoskova.judge1.model.entity.User;

/**
 * @author helena81
 * @version 1.0
 * @since 19.11.21
 */
public class CommentServiceModel extends BaseServiceModel{
    private int score;
    private String textContent;
    private UserServiceModel author;
    private HomeworkServiceModel homework;

    public CommentServiceModel() {
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public UserServiceModel getAuthor() {
        return author;
    }

    public void setAuthor(UserServiceModel author) {
        this.author = author;
    }

    public HomeworkServiceModel getHomework() {
        return homework;
    }

    public void setHomework(HomeworkServiceModel homework) {
        this.homework = homework;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
