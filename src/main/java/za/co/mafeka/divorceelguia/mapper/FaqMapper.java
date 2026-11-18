package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.faq.FaqDto;
import za.co.mafeka.divorceelguia.model.Faq;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FaqMapper {
    @Mapping(source = "phase.id", target = "phaseId")
    FaqDto toDto(Faq entity);
    List<FaqDto> toDtoList(List<Faq> list);
}
