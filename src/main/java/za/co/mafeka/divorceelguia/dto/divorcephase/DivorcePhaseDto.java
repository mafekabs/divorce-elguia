package za.co.mafeka.divorceelguia.dto.divorcephase;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import za.co.mafeka.divorceelguia.dto.guide.GuideDto;
import za.co.mafeka.divorceelguia.dto.PhaseChecklistItem.PhaseChecklistItemDto;

import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DivorcePhaseDto(
        UUID id,

        @NotNull
        String code,

        @NotNull
        String title,

        @NotNull
        String summary,

        @NotNull
        @JsonProperty("what-happens")
        String whatHappens,

        @NotNull
        @JsonProperty("how-long")
        String howLong,

        @NotNull
        @JsonProperty("common-mistakes")
        String commonMistakes,

        @NotNull
        @JsonProperty("display-order")
        Integer displayOrder,

        @NotNull
        @JsonProperty("check-list")
        List<PhaseChecklistItemDto> checklist,
        List<GuideDto> guides
) {}
