package com.amachi.app.hospitalappservice.dto;

import com.amachi.app.hospitalappservice.common.util.GenderEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Schema(name = "PatientContact", description = "Schema to hold PatientContact information")
public class PatientContactDTO {

	@JsonProperty
	@Schema(
			description = "Id of PatientContact", hidden = true
	)
	private Long idPatientContact;

	@Schema(
			description = "FirstName of Patient contact", example = "Eric"
	)
	@NotBlank(message = "Name {err.required}")
	private String firstName;

	@Schema(
			description = "MiddleName of Patient contact", example = "Jose"
	)
	private String middleName;

	@Schema(
			description = "LastName of Patient contact", example = "Bouchard"
	)
	@NotBlank(message = "Name {err.required}")
	private String lastName;

	@Schema(
			description = "The Gender of Patient contact", example = "MALE"
	)
	private GenderEnum gender = GenderEnum.MALE;

	@Schema(
			description = "The email of Patient contact", example = "mi.email@email.com"
	)
	@NotBlank(message = "Email {err.required}")
	private String email;

	@Schema(
			description = "The telephone of Patient contact", example = "mi.email@email.com"
	)
	@NotBlank(message = "Telephone {err.required}")
	private String telephone;

	@Schema(
			description = "The cellPhone of Patient contact", example = "mi.email@email.com"
	)
	private String cellPhone;

	@Schema(
			description = "The relation shipType of Patient contact", example = "mi.email@email.com"
	)
	private String  relationshipType;

	@Schema(
			description = "The notes of Patient contact", example = " bla bla bla"
	)
	private String notes;
}
