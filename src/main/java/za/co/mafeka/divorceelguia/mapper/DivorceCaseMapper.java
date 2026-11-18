package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.divorcecase.DivorceCaseDto;
import za.co.mafeka.divorceelguia.dto.divorcecase.DivorceCaseRequest;
import za.co.mafeka.divorceelguia.model.DivorceCase;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {DeadlineMapper.class})
public interface DivorceCaseMapper {
    @Mapping(source = "seeker.id", target = "seekerId")
    @Mapping(source = "office.id", target = "officeId")
    @Mapping(source = "office.name", target = "officeName")
    DivorceCaseDto toDto(DivorceCase entity);

    @Mapping(source = "divorceCase.seekerId", target = "seeker.id")
    @Mapping(source = "divorceCase.officeId", target = "office.id")
    @Mapping(target = "divorceCase.deadlines", ignore = true)
    DivorceCase toEntity(DivorceCaseRequest req);

    List<DivorceCaseDto> toDtoList(List<DivorceCase> list);
}
