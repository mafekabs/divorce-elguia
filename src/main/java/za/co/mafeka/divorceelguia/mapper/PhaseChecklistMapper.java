package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.PhaseChecklistItem.PhaseChecklistItemDto;
import za.co.mafeka.divorceelguia.model.PhaseChecklistItem;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhaseChecklistMapper {
    @Mapping(source = "phase.id", target = "phaseId")
    PhaseChecklistItemDto toDto(PhaseChecklistItem entity);
    List<PhaseChecklistItemDto> toDtoList(List<PhaseChecklistItem> list);
}
