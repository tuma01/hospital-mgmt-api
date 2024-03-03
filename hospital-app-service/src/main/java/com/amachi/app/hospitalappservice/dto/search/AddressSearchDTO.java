package com.amachi.app.hospitalappservice.dto.search;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
//@Hidden
public class AddressSearchDTO {
	
	private Long idAddress;
	private String address1;
	private String city;
	private String postalCode;

}
