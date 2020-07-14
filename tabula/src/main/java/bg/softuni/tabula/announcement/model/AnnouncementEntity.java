package bg.softuni.tabula.announcement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "announcements")
public class AnnouncementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "created_on")
    private Instant createdOn;

    @NotNull
    @Column(name = "updated_on")
    private Instant updatedOn;

    @NotNull
    @Column
    private String title;

    @NotNull
    @Column
    private String description;


}
