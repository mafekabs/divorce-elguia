package za.co.mafeka.divorceelguia.dto.office;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import za.co.mafeka.divorceelguia.dto.service.LegalServiceDto;

import java.util.Set;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record OfficeDto(
        UUID id,

        @NotNull
        String name,

        @NotNull
        String type,

        @NotNull
        String description,

        @NotNull
        @JsonProperty("what-they-do")
        String whatTheyDo,

        @NotNull
        @JsonProperty("what-they-dont-do")
        String whatTheyDontDo,

        @NotNull
        @JsonProperty("phone-number")
        String phoneNumber,

        @NotNull
        String whatsapp,

        @NotNull
        @JsonProperty("email-address")
        String emailAddress,

        @NotNull
        String website,

        @NotNull
        @JsonProperty("address-line1")
        String addressLine1,

        @NotNull
        String town,

        @NotNull
        @JsonProperty("province")
        String province,

        @NotNull
        @JsonProperty("gps-lat")
        Double gpsLat,

        @NotNull
        @JsonProperty("gps-lng")
        Double gpsLng,

        @NotNull
        @JsonProperty("operating-hours")
        String operatingHours,

        @NotNull
        @JsonProperty("language-spoken")
        String languagesSpoken,

        @NotNull
        @JsonProperty("capacity-notes")
        String capacityNotes,

        @NotNull
        @JsonProperty("is-active")
        Boolean isActive,

        @NotNull
        Set<LegalServiceDto> legalServices
) {}
