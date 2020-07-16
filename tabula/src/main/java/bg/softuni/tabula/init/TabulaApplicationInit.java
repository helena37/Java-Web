package bg.softuni.tabula.init;

import bg.softuni.tabula.announcement.model.AnnouncementEntity;
import bg.softuni.tabula.announcement.repository.AnnouncementRepository;
import bg.softuni.tabula.users.model.RoleEntity;
import bg.softuni.tabula.users.model.UserEntity;
import bg.softuni.tabula.users.repository.UserRepository;
import liquibase.pro.packaged.A;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@Component
public class TabulaApplicationInit implements CommandLineRunner {
    private final AnnouncementRepository announcementRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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

        if (this.userRepository.count() == 0) {
            //admin
            UserEntity admin = new UserEntity();
            admin.setEmail("lucho@example.com");
            admin.setPasswordHash(passwordEncoder.encode("topsecret"));

            RoleEntity adminAdminRole = new RoleEntity();
            adminAdminRole.setRole("ROLE_ADMIN");

            RoleEntity adminUserRole = new RoleEntity();
            adminUserRole.setRole("ROLE_USER");

            admin.setRoles(List.of(adminAdminRole, adminUserRole));

            this.userRepository.save(admin);

            //user
            UserEntity user = new UserEntity();
            user.setEmail("user@example.com");
            user.setPasswordHash(this.passwordEncoder.encode("topsecret"));

            RoleEntity userRole = new RoleEntity();
            userRole.setRole("ROLE_USER");

            user.setRoles(List.of(userRole));

            this.userRepository.save(user);
        }
    }
}
