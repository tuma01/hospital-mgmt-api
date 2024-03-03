package com.amachi.app.hospitalappservice.dto;

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
@Schema(name = "ProfessionalActivity", description = "Schema to hold ProfessionalActivity information")
public class ProfessionalActivityDTO {

	@JsonProperty
	@Schema(
			description = "Id ProfessionalActivity", hidden = true
	)
	private Integer idProfessionalActivity;

	@JsonProperty
	@Schema(
			description = "Name of ProfessionalActivity", example = "Ophthalmology"
	)
	@NotBlank(message = "Name {err.required}")
    private String name;

	@JsonProperty
	@Schema(
			description = "Description of ProfessionalActivity", example = "Diagnosis and treatment of eye conditions"
	)
	private String description;

}
