package com.amachi.app.hospitalappservice.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Hidden
public final class CountrySearchDTO {
	@Schema(hidden = true)
	private Integer idCountry;
	private String iso;
	private String name;

}
