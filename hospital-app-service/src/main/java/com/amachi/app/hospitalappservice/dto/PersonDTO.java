package com.amachi.app.hospitalappservice.dto;

import com.amachi.app.hospitalappservice.common.util.CivilStatusEnum;
import com.amachi.app.hospitalappservice.common.util.GenderEnum;
import com.amachi.app.hospitalappservice.common.util.MaritalStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(name = "Person", description = "Schema to hold Person information")
public class PersonDTO {

    //	@Builder.Default
    @Valid
    @JsonProperty
    @Schema(
            description = "Id of Person", hidden = true
    )
    private Long id = 0L;

    //	@Builder.Default
    @Valid
    @JsonProperty
    private String title = "";

    //	@Builder.Default
    @Valid
    @JsonProperty
    @NotBlank(message = "First name {err.mandatory}")
    @Schema(
            description = "FirstName of Person ", example = "Eric"
    )
    private String firstName;

    //	@Builder.Default
    @Valid
    @JsonProperty
    @Schema(
            description = "MiddleName of Person", example = "Juan"
    )
    private String middleName;

    //	@Builder.Default
    @Valid
    @JsonProperty
    @NotBlank(message = "Last name is mandatory")
    @Schema(
            description = "LastName of Person", example = "Bouchard"
    )
    private String lastName;

    //	@Builder.Default
    @Valid
    @JsonProperty
    @Schema(
            description = "Day Of Birth of Person", example = "24"
    )
    private Integer dayOfBirth;

    //	@Builder.Default
    @Valid
    @JsonProperty
    private CivilStatusEnum civilStatus = CivilStatusEnum.SOLTERO;

    //	@Builder.Default
    @Valid
    @JsonProperty
    @Schema(
            description = "Month Of Birth of Person", example = "06"
    )
    private Integer monthOfBirth;

    //	@Builder.Default
    @Valid
    @JsonProperty
    @Schema(
            description = "Year Of Birth of Person", example = "2000"
    )
    private Integer yearOfBirth;

    //	@Builder.Default
    @Valid
    @JsonProperty
    @Schema(
            description = "Birthday of Person"
    )
    private LocalDate birthday;

    //	@Builder.Default
    @Valid
    @JsonProperty
    private GenderEnum gender = GenderEnum.UNKNOWN;

    //	@Builder.Default
    @Valid
    @JsonProperty
    @Schema(
            description = " The address of Person"
    )
    private AddressDTO address;

    @JsonProperty
    @Pattern(regexp=".+@.+\\.[a-z]+")
    @NotBlank(message = "Email {err.required}")
    @Schema(
            description = "The email of Person", example = "mi.email@email.com"
    )
    private String email;

    @JsonProperty
    @Schema(
            description = "The telephone of Patient contact", example = "514 2367944"
    )
    @NotBlank(message = "Telephone {err.required}")
    private String telephone;

    //	@Builder.Default
    @Valid
    @JsonProperty
    @Schema(
            description = "The cellPhone of Person", example = "mi.email@email.com"
    )
    private String cellPhone;

    //	@Builder.Default
    @Valid
    @JsonProperty
    private MaritalStatusEnum maritalStatus = MaritalStatusEnum.SINGLE;
}
