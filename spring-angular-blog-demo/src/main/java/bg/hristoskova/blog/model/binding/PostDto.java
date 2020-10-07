package bg.hristoskova.blog.model.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String username;

    public PostDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Size(min = 3, message = "Title should be at least 3 characters!")
    @NotNull(message = "Title is a required field")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Size(min = 6, message = "Blog should contains at least 6 characters!")
    @NotNull(message = "Blog content is a required field")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
