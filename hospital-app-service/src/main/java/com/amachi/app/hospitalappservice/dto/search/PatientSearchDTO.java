package com.amachi.app.hospitalappservice.dto.search;

import com.amachi.app.hospitalappservice.common.util.StatusEnum;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Hidden
public class PatientSearchDTO {
	private String idCard;
	private String fullName;
	private String firstName;
	private String middleName;
	private String lastName;
	private StatusEnum status = StatusEnum.INACTIVE;
}
