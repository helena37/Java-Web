package bg.softuni.tabula.announcement.service;

import bg.softuni.tabula.announcement.model.dto.AnnouncementDTO;

import java.util.List;

public interface AnnouncementService {
    List<AnnouncementDTO> findAll();

    void cleanUpOldAnnouncements();
}
