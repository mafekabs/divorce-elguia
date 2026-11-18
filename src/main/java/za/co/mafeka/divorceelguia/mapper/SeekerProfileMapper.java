package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.seekerprofile.SeekerProfileDto;
import za.co.mafeka.divorceelguia.dto.seekerprofile.SeekerProfileRequest;
import za.co.mafeka.divorceelguia.model.SeekerProfile;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SeekerProfileMapper {
    @Mapping(source = "user.id", target = "userId")
    SeekerProfileDto toDto(SeekerProfile entity);

    @Mapping(source = "seekerProfile.userId", target = "user.id")
    SeekerProfile toEntity(SeekerProfileRequest req);

    List<SeekerProfileDto> toDtoList(List<SeekerProfile> list);
}
