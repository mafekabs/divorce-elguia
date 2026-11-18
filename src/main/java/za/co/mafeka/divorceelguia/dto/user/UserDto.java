package za.co.mafeka.divorceelguia.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDto(
        UUID id,

        @NotNull
        @JsonProperty("first-name")
        String firstName,

        @NotNull
        @JsonProperty("last-name")
        String lastName,

        @NotNull
        @JsonProperty("mobile-number")
        String mobileNumber,

        @NotNull
        @JsonProperty("email-address")
        String emailAddress,

        @NotNull
        String role,

        @NotNull
        @JsonProperty("preferred-language")
        String preferredLanguage,

        @NotNull
        String province,

        @NotNull
        String town,

        @JsonProperty("created-at")
        LocalDateTime createdAt


) {}
