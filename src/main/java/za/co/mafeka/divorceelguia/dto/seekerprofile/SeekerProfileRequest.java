package za.co.mafeka.divorceelguia.dto.seekerprofile;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record SeekerProfileRequest(
        @NotNull
        @JsonProperty("seeker-profile")
        SeekerProfileDto seekerProfile
) {}