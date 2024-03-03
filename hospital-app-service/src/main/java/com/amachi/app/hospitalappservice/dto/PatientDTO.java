package com.amachi.app.hospitalappservice.dto;

import com.amachi.app.hospitalappservice.common.util.StatusEnum;
import com.amachi.app.hospitalappservice.entities.Insurance;
import com.amachi.app.hospitalappservice.entities.Nurse;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Blob;


@Data @AllArgsConstructor @NoArgsConstructor @ToString
@EqualsAndHashCode(callSuper=true)
//@SuperBuilder(toBuilder = true)
@Schema(name = "Patient", description = "Schema to hold Patient information")
public class PatientDTO extends PersonDTO {

	@Schema(
			description = "Id Card of Patient ", example = "123457"
	)
	private String idCard;

	@Schema(
			description = "Full Name of Patient ", example = "Jose Patin"
	)
	@NotBlank(message = "Full Name {err.required}")
	private String fullName;

	@Schema(
			description = "this is status of Patient", example = "INACTIVE"
	)
	private StatusEnum status = StatusEnum.INACTIVE;

	@Schema(
			description = "The occupation of Patient", example = "Nurse"
	)
	private String occupation;

	@Schema(
			description = "The Nationality of the Patient", example = "Canada"
	)
	private String nationality;

	@Schema(
			description = "Degree of Instruction of the Patient", example = "Universitario"
	)
	private String degreeOfInstruction;

	@Schema(
			description = "The Country of Patient", example = "Bolivia"
	)
	private CountryDTO countryOfBirth;

//	@Default
//	@lombok.EqualsAndHashCode.Exclude
//	@lombok.ToString.Exclude
//	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade=CascadeType.DETACH , orphanRemoval=true)
//	private Set<Consultation> consultations = new LinkedHashSet<>();

	@Schema(
			description = "The room where the patient is located"
	)
	@JsonProperty
	private RoomDTO room;

	@Schema(
			description = "The Contact of the Patient"
	)
	@JsonProperty
	private PatientContactDTO patientContact;

	@Schema(
			description = "The Photo of the Patient"
	)
	@JsonProperty
	private Blob photo;

	@Schema(
			description = "The Insurance company of the Patient"
	)
	@JsonProperty
	private InsuranceDTO insurance;

	@Schema(
			description = "The Nurse of the Patient"
	)
	@JsonProperty
	private Nurse nurse;

}
