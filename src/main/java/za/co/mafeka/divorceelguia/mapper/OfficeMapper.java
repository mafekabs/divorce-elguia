package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.office.OfficeDto;
import za.co.mafeka.divorceelguia.dto.office.OfficeRequest;
import za.co.mafeka.divorceelguia.model.Office;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {LegalServiceMapper.class})
public interface OfficeMapper {
    OfficeDto toDto(Office entity);

    @Mapping(target = "req.office.legalServices", ignore = true) // set manually from serviceIds in service layer
    @Mapping(target = "req.office.appointments", ignore = true)
    Office toEntity(OfficeRequest req);

    @Mapping(target = "req.office.id", ignore = true)
    @Mapping(target = "req.office.legalServices", ignore = true)
    @Mapping(target = "req.office.appointments", ignore = true)
    void updateEntityFromDto(OfficeRequest req, @MappingTarget Office entity);

    List<OfficeDto> toDtoList(List<Office> list);
}
