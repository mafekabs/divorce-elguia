package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.guide.GuideDto;
import za.co.mafeka.divorceelguia.dto.guide.GuideRequest;
import za.co.mafeka.divorceelguia.model.Guide;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GuideMapper {
    @Mapping(source = "phase.id", target = "phaseId")
    GuideDto toDto(Guide entity);

    @Mapping(source = "guide.phaseId", target = "phase.id")
    Guide toEntity(GuideRequest req);

    List<GuideDto> toDtoList(List<Guide> list);
}
