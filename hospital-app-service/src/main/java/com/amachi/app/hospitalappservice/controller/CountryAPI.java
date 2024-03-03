package com.amachi.app.hospitalappservice.controller;

import com.amachi.app.hospitalappservice.common.exception.NoParametersProvidedException;
import com.amachi.app.hospitalappservice.dto.CountryDTO;
import com.amachi.app.hospitalappservice.dto.request.GetCountriesRequest;
import com.amachi.app.hospitalappservice.dto.search.CountrySearchDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@Tag(name = "Rest API for Country in Hospital App", description = "Rest API Hospital APP to CREATE, UPDATE, FETCH and DELETE Country details")
public interface CountryAPI {

	@Operation(
		summary = "Retrieve a Country by Id",
		method = "getCountry",
		description = "Get a Country object by specifying id. The response is Country object with id")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of Countries returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/countries/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<CountryDTO> getCountry(@Parameter(required = true) @PathVariable("id") Integer idCountry);

	@Operation(summary = "Create a Country", description = "Country Object send as body parameters")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "ConsultationType modified successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@PostMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<CountryDTO> addCountry(@Parameter(description = "Create a Country", required = true) @Valid @RequestBody CountryDTO countryDTO);

	@Operation(summary = "Modify Country", method = "updateCountry", description = "Modify Country by ID and Country Object send as body parameters")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Country modified successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@PutMapping(value = "/countries/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<CountryDTO> updateCountry(@Parameter(description = "Update Country", required = true) @PathVariable("id") Integer idCountry, @Valid @RequestBody CountryDTO countryDTO);

	@Operation(summary = "Delete Country", method = "deleteCountry", description = "Delete an Country by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Delete Address successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@DeleteMapping(value = "/countries/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object> deleteCountry(@Parameter(description = "Delete objet Country", required = true) @PathVariable("id") Integer idCountry);

	@Operation(summary = "Retrieve all Countries")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of Countries returned successfully"),
		@ApiResponse(responseCode = "204", description = "There are no Country"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Page<CountryDTO>> getCountries(CountrySearchDTO countrySearchDTO,
														  @RequestParam(value = "pageNumber", defaultValue = "10", required = false)final Integer pageNumber,
														  @RequestParam(value = "pageSize", defaultValue = "1", required = false)final Integer pageSize,
														  @RequestParam(value = "sort", defaultValue = "idCountry", required = false)final String sort);

	@Operation(summary = "Returns the list of Countries", method = "findAllCountries", description = "Returns the list of Countries")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of Countries returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/countriesall", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<CountryDTO>> findAllCountries();
//	ResponseEntity<List<CountryDTO>> findAllCountries(GetCountriesRequest getCountriesRequest) throws NoParametersProvidedException;
}