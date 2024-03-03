package com.amachi.app.hospitalappservice.dto.search;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Hidden
public class ConsultationTypeSearchDTO {
	private Integer idConsultationType;
	private String name;
	private String description;

}
