package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.divorcephase.DivorcePhaseDto;
import za.co.mafeka.divorceelguia.model.DivorcePhase;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {PhaseChecklistMapper.class, GuideMapper.class})
public interface DivorcePhaseMapper {
    DivorcePhaseDto toDto(DivorcePhase entity);
    List<DivorcePhaseDto> toDtoList(List<DivorcePhase> list);
}
