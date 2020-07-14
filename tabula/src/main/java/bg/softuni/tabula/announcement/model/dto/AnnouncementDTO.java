package bg.softuni.tabula.announcement.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnnouncementDTO {
    private Long id;

    private Instant createdOn;

    private Instant updatedOn;

    @NotBlank
    private String title;

    @NotBlank
    @Size(min = 10, message = "The description should be more than 10 characters!")
    private String description;


}
