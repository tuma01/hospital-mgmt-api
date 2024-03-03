package com.amachi.app.hospitalappservice.dto;

import com.amachi.app.hospitalappservice.entities.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Validated
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Insurance", description = "Schema to hold Insurance information")
public class InsuranceDTO {

    @JsonProperty
    @Schema(
            description = "Id Insurance of Patient", hidden = true
    )
    private Integer idInsurance;


    @JsonProperty
    @Schema(
            description = "Insurance Number of Insurance", example = "1012"
    )
    @NotBlank(message = "Insurance Number {err.required}")
    private Integer insurance_Number;

    @JsonProperty
    @Schema(
            description = "Name of Insurance", example = "La Capital Insurance"
    )
    @NotBlank(message = "Name {err.required}")
    private String name;

    @JsonProperty
    @Schema(
            description = "The telephone of Insurance", example = "514 2234567"
    )
    private String telephone;

    @JsonProperty
    @Schema(
            description = "The fax of Insurance", example = "514 2234588"
    )
    private String fax;

    @JsonProperty
    @Schema(
            description = "The site web of Insurance", example = "www.insurance.com"
    )
    private String webSite;

    @JsonProperty
    @Schema(
            description = "The date of Insurance", example = "123456"
    )
    private LocalDate insuranceDate;

    @JsonProperty
    @Schema(
            description = " The address of Insurance"
    )
    private Address address;
}
