package com.amachi.app.hospitalappservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.validation.Valid;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Schema(name = "ConsultationType", description = "Schema to hold ConsultationType information")
public class ConsultationTypeDTO {

	@JsonProperty
	@Schema(
			description = "Id ConsultationType of Hospital ConsultationType", hidden = true
	)
	private Integer idConsultationType;


	@JsonProperty
	@Schema(
			description = "Name of ConsultationType ", example = "Ophthalmology"
	)
	@NotBlank(message = "Name {err.required}")
    private String name;

	@JsonProperty
	@Schema(
			description = "Description of ConsultationType ", example = "Diagnosis and treatment of eye conditions"
	)
	private String description;

	@JsonProperty
	@Schema(
			description = "Department of ConsultationType ", example = "Ophthalmology"
	)
	private String department;

}
