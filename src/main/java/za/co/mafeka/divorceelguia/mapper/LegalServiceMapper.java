package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.service.LegalServiceDto;
import za.co.mafeka.divorceelguia.dto.service.LegalServiceRequest;
import za.co.mafeka.divorceelguia.model.LegalService;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LegalServiceMapper {
    LegalServiceDto toDto(LegalService entity);
    LegalService toEntity(LegalServiceRequest req);
    List<LegalServiceDto> toDtoList(List<LegalService> list);
    java.util.Set<LegalServiceDto> toDtoSet(java.util.Set<LegalService> set);
}