package com.amachi.app.hospitalappservice.controller;

import com.amachi.app.hospitalappservice.dto.AddressDTO;
import com.amachi.app.hospitalappservice.dto.search.AddressSearchDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Rest API for Address in Hospital App", description = "Rest API in Hospital App to CREATE, UPDATE, FETCH and DELETE Address details")
//@RequestMapping("/medical/")
public interface AddressAPI {
	
	@Operation(summary = "Retrieve a Address by Id", method = "getAddress", description = "Get a Address object by specifying id. The response is Address object")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Address returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/addresses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<AddressDTO> getAddress(@Parameter(description = "Return objet Address", required = true) @PathVariable("id") Long idAddress);


	@Operation(summary = "Create a Address", method = "addAddress", description = "Address Object send as body parameters")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Address created successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@PostMapping(value = "/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<AddressDTO> addAddress(@Parameter(required = true) @Valid @RequestBody AddressDTO addressDTO);

	@Operation(summary = "Modify an Address", method = "updateAddress", description = "Modify Address by ID and Address Object send as body parameters")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Address modified successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@PutMapping(value = "/addresses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<AddressDTO> updateAddress(@Parameter(description = "Modify Address by ID", required = true) @PathVariable("id") Long idAddress, @Valid @RequestBody AddressDTO addressDTO);

	@Operation(summary = "Delete an Address", method = "deleteAddress", description = "Delete an Address by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Delete Address successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@DeleteMapping(value = "/addresses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object> deleteAddress(@Parameter(description = "Delete objet Address by ID", required = true) @PathVariable("id") Long idAddress);

	@Operation(summary = "Returns the list of Addresses", method = "getAddresses", description = "Returns the list of Addresses")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of Address returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Page<AddressDTO>> getAddresses(AddressSearchDTO addressSearchDTO,
														 @RequestParam(value = "pageNumber", defaultValue = "10", required = false)final Integer pageNumber,
														 @RequestParam(value = "pageSize", defaultValue = "1", required = false)final Integer pageSize,
														 @RequestParam(value = "sort", defaultValue = "idCountry", required = false)final String sort);


	@Operation(summary = "Returns the list of Addresses", method = "findAllAddresses", description = "Returns the list of Addresses")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of Address returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/addressesall", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<AddressDTO>> findAllAddresses();
}
