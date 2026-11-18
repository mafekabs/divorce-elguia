package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.deadline.DeadlineDto;
import za.co.mafeka.divorceelguia.model.Deadline;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeadlineMapper {
    @Mapping(source = "divorceCase.id", target = "caseId")
    @Mapping(target = "daysRemaining", ignore = true) // calculated in service
    DeadlineDto toDto(Deadline entity);

    @Mapping(source = "caseId", target = "divorceCase.id")
    Deadline toEntity(DeadlineDto dto);
    List<DeadlineDto> toDtoList(List<Deadline> list);
}