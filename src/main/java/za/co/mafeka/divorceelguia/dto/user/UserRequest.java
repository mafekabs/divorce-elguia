package za.co.mafeka.divorceelguia.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserRequest(
        @NotNull
        @JsonProperty("user")
        UserDto user
) {}
