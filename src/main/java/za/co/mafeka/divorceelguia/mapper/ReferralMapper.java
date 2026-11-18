package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.referral.CreateReferralRequest;
import za.co.mafeka.divorceelguia.dto.referral.ReferralDto;
import za.co.mafeka.divorceelguia.model.Referral;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReferralMapper {
    @Mapping(source = "triageSession.id", target = "triageSessionId")
    @Mapping(source = "fromOffice.id", target = "fromOfficeId")
    @Mapping(source = "fromOffice.name", target = "fromOfficeName")
    @Mapping(source = "toOffice.id", target = "toOfficeId")
    @Mapping(source = "toOffice.name", target = "toOfficeName")
    ReferralDto toDto(Referral entity);

    @Mapping(source = "triageSessionId", target = "triageSession.id")
    @Mapping(source = "fromOfficeId", target = "fromOffice.id")
    @Mapping(source = "toOfficeId", target = "toOffice.id")
    Referral toEntity(CreateReferralRequest req);

    List<ReferralDto> toDtoList(List<Referral> list);
}
