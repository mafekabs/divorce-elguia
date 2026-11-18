package za.co.mafeka.divorceelguia.dto.seekerprofile;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record SeekerProfileResponse(
        @NotNull
        @JsonProperty("seeker-profile")
        SeekerProfileDto seekerProfileDto
) {}