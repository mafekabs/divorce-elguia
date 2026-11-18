package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.feedback.FeedbackDto;
import za.co.mafeka.divorceelguia.dto.feedback.FeedbackRequest;
import za.co.mafeka.divorceelguia.model.Feedback;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FeedbackMapper {
    @Mapping(source = "triageSession.id", target = "triageSessionId")
    FeedbackDto toDto(Feedback entity);

    @Mapping(source = "feedback.triageSessionId", target = "triageSession.id")
    Feedback toEntity(FeedbackRequest req);
}
