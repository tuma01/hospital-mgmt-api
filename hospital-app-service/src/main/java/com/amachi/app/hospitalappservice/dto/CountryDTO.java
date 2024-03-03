package com.amachi.app.hospitalappservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


@Validated
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Country", description = "Schema to hold Country information")
public class CountryDTO {

	@JsonProperty
	@Schema(
			description = "Id Country of Hospital Country", hidden = true
	)
    private Integer idCountry;

	@JsonProperty
	@NotNull(message = "Iso code shouldn't be null")
	@Schema(
			description = "ISO code Country of Hospital", example = "BO"
	)
    private String iso;

	@JsonProperty
	@Size(min=3,max=80,message="The length must be between {min} and {max}")
//	@NotEmpty(message = "Name of Country can not be a null or empty")
	@NotBlank(message = "Name {err.required}")
	@Schema(
			description = "Name of Hospital Country", example = "BOLIVIA"
	)
    private String name;

	@JsonProperty
	@Size(min=3, max=80, message="The length must be between {min} and {max}")
	@Schema(
			description = "Nice name of Hospital Country", example = "Bolivia"
	)
	private String niceName;


	@JsonProperty
//	@Pattern(regexp = "(^$|[0-9]{3})", message = "ISO3 must be 3 digits")
//	@NotEmpty(message = "Nice Name of Country can not be a null or empty")
	@Size(min = 1, max = 3, message="The length must be between {min} and {max}")
	@Schema(
			description = "ISO3 of Hospital Country", example = "BOL"
	)
    private String iso3;

	@JsonProperty
	@Schema(
			description = "Num Code Country of Hospital", example = "68"
	)
    private Integer numCode;

	@JsonProperty
//	@Size(max = 5)
	@NotNull(message = "Phone code shouldn't be null")
	@Schema(
			description = "Code Phone of Hospital Country", example = "591"
	)
	private Integer phoneCode;

}
