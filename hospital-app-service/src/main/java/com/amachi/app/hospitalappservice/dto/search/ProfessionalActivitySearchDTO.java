package com.amachi.app.hospitalappservice.dto.search;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Hidden
public class ProfessionalActivitySearchDTO {
	private Integer idProfessionalActivity;
	private String name;
	private String description;

    public Integer getIdProfessionalActivity() {
		return this.idProfessionalActivity;
    }

	public String getName() {
		return this.name;
	}
}
