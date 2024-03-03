package com.amachi.app.hospitalappservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Schema(name = "Address", description = "Schema to hold Address information")
public class AddressDTO {

	@JsonProperty
	@Schema(
			description = "Id Address of Hospital Address"
	)
	private Long idAddress;

	@JsonProperty
	@Schema(
			description = "Address principal", example = "11957 Avenue Jubinville"
	)
	@NotBlank(message = "Address {err.required}")
	private String address1;

	@JsonProperty
	@Schema(
			description = "An optional second line of an address"
	)
	private String address2;

	@JsonProperty
	@Schema(
			description = "The city of an address", example = "Montreal"
	)
	private String city;

	@JsonProperty
	@Schema(
			description = "The postal code of the address", example = "H1G 3T3"
	)
	private String postalCode;

	@JsonProperty
	@Schema(
			description = "Geometry data with spatial index"
	)
	private String location;


	@JsonProperty
	@Schema(
			description = "The Country of Address"
	)
	private CountryDTO country;

}
