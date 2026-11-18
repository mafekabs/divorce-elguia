package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.publicholiday.PublicHolidayDto;
import za.co.mafeka.divorceelguia.model.PublicHoliday;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PublicHolidayMapper {
    PublicHolidayDto toDto(PublicHoliday entity);
    PublicHoliday toEntity(PublicHolidayDto dto);
    List<PublicHolidayDto> toDtoList(List<PublicHoliday> list);
}
