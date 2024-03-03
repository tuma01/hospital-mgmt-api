package com.amachi.app.hospitalappservice.controller;

import com.amachi.app.hospitalappservice.dto.PatientDTO;
import com.amachi.app.hospitalappservice.dto.search.PatientSearchDTO;
import com.amachi.app.hospitalappservice.util.AppConstants;
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

@Tag(name = "Rest API for Patient in Hospital App", description = "Rest API in Hospital App to CREATE, UPDATE, FETCH and DELETE Patient details")
public interface PatientAPI {

	static final String DEFAULT_SORT_BY_ID = AppConstants.DEFAULT_SORT_BY;
	
	@Operation(summary = "Retourne un Patient", method = "getPatient", description = "Envoye en tant que query parameters")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Patient returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/patients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<PatientDTO> getPatient(@Parameter(description = "Return objet Patient", required = true) @PathVariable("id") Long id);

	@Operation(summary = "Create a Patient", method = "addPatient", description = "Patient Object send as body parameters")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Patient created successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@PostMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<PatientDTO> addPatient(@Parameter(description = "Créé objet Patient", required = true) @Valid @RequestBody PatientDTO patientDTO);
	
	@Operation(summary = "Modify a Patient", method = "updatePatient", description = "Modify Patient by ID and Patient Object send as body parameter")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Patient modified successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@PutMapping(value = "/patients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<PatientDTO> updatePatient(@Parameter(description = "Modify objet Patient", required = true) @PathVariable("id") Long id,  @Valid @RequestBody PatientDTO patientDTO);

	@Operation(summary = "Delete a Patient", method = "deletePatient", description = "Delete Patient by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Delete Patient successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@DeleteMapping(value = "/patients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object> deletePatient(@Parameter(description = "Delete objet Patient", required = true) @PathVariable("id") Long id);
	
	@Operation(summary = "Returns the list of Patients", method = "getPatients", description = "Returns the list of Patients")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of Patients returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Page<PatientDTO>> getPatients(final PatientSearchDTO patientSearchDTO,
												  @RequestParam(value = "pageNumber", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) final Integer pageNumber,
												  @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) final Integer pageSize,
												  @RequestParam(value = "sort", defaultValue = DEFAULT_SORT_BY_ID, required = false) final String sort);

		
	@Operation(summary = "Returns the list of Patients", method = "findAllPatients", description = "Returns the list of Patients")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of Patients returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/patientsallparams", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<PatientDTO>> findAllPatients();
}
