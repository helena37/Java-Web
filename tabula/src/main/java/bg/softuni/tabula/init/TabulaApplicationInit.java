package bg.softuni.tabula.init;

import bg.softuni.tabula.announcement.model.AnnouncementEntity;
import bg.softuni.tabula.announcement.repository.AnnouncementRepository;
import liquibase.pro.packaged.A;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@AllArgsConstructor
@Component
public class TabulaApplicationInit implements CommandLineRunner {
    private final AnnouncementRepository announcementRepository;

    @Override
    public void run(String... args) throws Exception {
        if (this.announcementRepository.count() == 0) {
            AnnouncementEntity announcementEntity = new AnnouncementEntity();
            announcementEntity.setTitle("Hello, SoftUni!");
            announcementEntity.setDescription("Welcome to the Spring Advanced Course!");
            announcementEntity.setCreatedOn(Instant.now());
            announcementEntity.setUpdatedOn(Instant.now());

            this.announcementRepository.save(announcementEntity);
        }
    }
}
