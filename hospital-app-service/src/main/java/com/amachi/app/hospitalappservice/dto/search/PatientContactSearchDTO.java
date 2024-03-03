package com.amachi.app.hospitalappservice.dto.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientContactSearchDTO {
	private String idCard;
	private String fullName;
	private String firstName;
	private String middleName;
	private String lastName;
}
