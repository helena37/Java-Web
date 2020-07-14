package bg.softuni.tabula.announcement.model;

import bg.softuni.tabula.announcement.model.dto.AnnouncementDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnnouncementMapper {
    AnnouncementMapper INSTANCE = Mappers.getMapper(AnnouncementMapper.class);

    AnnouncementEntity mapAnnouncementDtoToEntity(AnnouncementDTO dto);

    AnnouncementDTO mapAnnouncementEntityToDto(AnnouncementEntity entity);

}
