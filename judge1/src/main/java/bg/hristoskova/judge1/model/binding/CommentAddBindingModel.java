package bg.hristoskova.judge1.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author helena81
 * @version 1.0
 * @since 19.11.21
 */
public class CommentAddBindingModel {
    private int score;
    private String textContent;
    private String homeworkId;

    public CommentAddBindingModel() {
    }

    @Min(value = 2, message = "Score must be between 2 and 6 inclusive!")
    @Max(value = 6, message = "Score must be between 2 and 6 inclusive!")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Length(min = 3, message = "Comments must be at least 3 characters!")
    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
    }
}
