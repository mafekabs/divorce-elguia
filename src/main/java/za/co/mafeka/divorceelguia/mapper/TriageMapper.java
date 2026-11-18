package za.co.mafeka.divorceelguia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import za.co.mafeka.divorceelguia.dto.TriageAnswerOption.TriageAnswerOptionDto;
import za.co.mafeka.divorceelguia.dto.TriageQuestion.TriageQuestionDto;
import za.co.mafeka.divorceelguia.dto.triageresult.TriageResultDto;
import za.co.mafeka.divorceelguia.dto.triagerule.TriageRuleDto;
import za.co.mafeka.divorceelguia.model.TriageAnswerOption;
import za.co.mafeka.divorceelguia.model.TriageQuestion;
import za.co.mafeka.divorceelguia.model.TriageRule;
import za.co.mafeka.divorceelguia.model.TriageSession;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TriageMapper {
    TriageQuestionDto toDto(TriageQuestion entity);
    List<TriageQuestionDto> toDtoList(List<TriageQuestion> list);

    TriageAnswerOptionDto toOptionDto(TriageAnswerOption entity);

    TriageRuleDto toDto(TriageRule entity);

    // TriageSession -> TriageResultDto is built manually in service (needs OfficeDto + checklist)
    // This is only for simple mapping
    @Mapping(source = "resultOffice", target = "recommendedOffice")
    TriageResultDto toResultDto(TriageSession session);
}
