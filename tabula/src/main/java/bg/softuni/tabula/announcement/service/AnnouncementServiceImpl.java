package bg.softuni.tabula.announcement.service;

import bg.softuni.tabula.announcement.model.AnnouncementMapper;
import bg.softuni.tabula.announcement.model.dto.AnnouncementDTO;
import bg.softuni.tabula.announcement.repository.AnnouncementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;

    @Override
    public List<AnnouncementDTO> findAll() {
        return this.announcementRepository
                .findAll()
                .stream()
                .map(AnnouncementMapper.INSTANCE::mapAnnouncementEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void cleanUpOldAnnouncements() {
        Instant endTime = Instant.now().minus(7, ChronoUnit.DAYS);
        this.announcementRepository.deleteByUpdatedOnBefore(endTime);
    }
}
