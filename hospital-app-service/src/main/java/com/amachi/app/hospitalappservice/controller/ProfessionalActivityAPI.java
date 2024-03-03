package com.amachi.app.hospitalappservice.controller;

import com.amachi.app.hospitalappservice.dto.ProfessionalActivityDTO;
import com.amachi.app.hospitalappservice.dto.search.ProfessionalActivitySearchDTO;
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

@Tag(name = "Rest API for ProfessionalActivity in Hospital App", description = "Rest API Hospital APP to CREATE, UPDATE, FETCH and DELETE ProfessionalActivity details")
public interface ProfessionalActivityAPI {
	
	@Operation(summary = "Retrieve a ProfessionalActivity", method = "getProfessionalActivity",
			description = "Get a ProfessionalActivity object by specifying id. The response is ProfessionalActivity object with id")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of Countries returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/professionalActivities/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ProfessionalActivityDTO> getProfessionalActivity(@Parameter(description = "Return objet ProfessionalActivity", required = true) @PathVariable("id") Integer idProfessionalActivity);

	@Operation(summary = "Create a ProfessionalActivity", method = "addProfessionalActivity", description = "ProfessionalActivity Object send as body parameters")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of Countries returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@PostMapping(value = "/professionalActivities", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ProfessionalActivityDTO> addProfessionalActivity(@Parameter(description = "Créé objet ProfessionalActivity", required = true) @Valid @RequestBody ProfessionalActivityDTO professionalActivityDTO);
	
	@Operation(summary = "Modify ProfessionalActivity", method = "updateProfessionalActivity", description = "Modify ProfessionalActivity by ID and ProfessionalActivity Object send as body parameters")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of ProfessionalActivities returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@PutMapping(value = "/professionalActivities/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ProfessionalActivityDTO> updateProfessionalActivity(@Parameter(description = "Modify objet ProfessionalActivity", required = true) @PathVariable("id") Integer idProfessionalActivity, @Valid @RequestBody ProfessionalActivityDTO professionalActivityDTO);

	@Operation(summary = "Delete ProfessionalActivity", method = "deleteProfessionalActivity", description = "Delete an ProfessionalActivity by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Delete ProfessionalActivity successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@DeleteMapping(value = "/professionalActivities/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object> deleteProfessionalActivity(@Parameter(description = "Delete objet ProfessionalActivity", required = true) @PathVariable("id") Integer idProfessionalActivity);
	
	@Operation(summary = "Returns the list of  ProfessionalActivities", method = "getProfessionalActivities", description = "Returns the list of ProfessionalActivities")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of ProfessionalActivities returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/professionalActivities", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Page<ProfessionalActivityDTO>> getProfessionalActivities(final ProfessionalActivitySearchDTO professionalActivitySearchDTO,
												  @RequestParam(value = "pageNumber", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false)final Integer pageNumber,
												  @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false)final Integer pageSize,
												  @RequestParam(value = "sort", defaultValue = "idProfessionalActivity", required = false)final String sort);
	
		
	@Operation(summary = "Retrieve all ProfessionalActivities", method = "findAllProfessionalActivities", description = "Returns the list of ProfessionalActivities")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of ProfessionalActivities returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/professionalActivitiesAll", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<ProfessionalActivityDTO>> findAllProfessionalActivities();
}
