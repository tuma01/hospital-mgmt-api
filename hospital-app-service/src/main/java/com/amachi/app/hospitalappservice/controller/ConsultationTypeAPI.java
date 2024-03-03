package com.amachi.app.hospitalappservice.controller;

import com.amachi.app.hospitalappservice.dto.ConsultationTypeDTO;
import com.amachi.app.hospitalappservice.dto.search.ConsultationTypeSearchDTO;
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

@Tag(name = "Rest API for ConsultationType in Hospital APP", description = "Rest API Hospital APP to CREATE, UPDATE, DELETE and FETCH ConsultationTYpe details")
public interface ConsultationTypeAPI {
	
	@Operation(summary = "Retrieve a ConsultationType by Id", method = "getConsultationType", description = "Get a ConsultationType object by specifying id. The response is ConsultationType object")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of ConsultationType returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/consultationTypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ConsultationTypeDTO> getConsultationType(@Parameter(description = "Return objet ConsultationType", required = true) @PathVariable("id") Integer idConsultationType);

	@Operation(summary = "Create a ConsultationType", method = "addConsultationType", description = "ConsultationType Object send as body parameters")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "ConsultationType modified successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@PostMapping(value = "/consultationTypes", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ConsultationTypeDTO> addConsultationType(@Parameter(description = "Create a ConsultationType", required = true) @Valid @RequestBody ConsultationTypeDTO consultationTypeDTO);
	
	@Operation(summary = "Modify an ConsultationType", method = "updateConsultationType", description = "Modify ConsultationType by ID and ConsultationType Object send as body parameters")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "ConsultationType modified successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@PutMapping(value = "/consultationTypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ConsultationTypeDTO> updateConsultationType(@Parameter(description = "Update an ConsultationType", required = true) @PathVariable("id") Integer idConsultationType, @Valid @RequestBody ConsultationTypeDTO consultationTypeDTO);

	@Operation(summary = "Delete an ConsultationType", method = "deleteConsultationType", description = "Delete an ConsultationType by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Delete Address successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@DeleteMapping(value = "/consultationTypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteConsultationType(@Parameter(description = "Delete objet ConsultationType", required = true) @PathVariable("id") Integer idConsultationType);
	
	@Operation(summary = "Returns the list of ConsultationTypes", method = "getConsultationTypes", description = "Returns the list of ConsultationType")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of ConsultationTypes returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/consultationTypes", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Page<ConsultationTypeDTO>> getConsultationTypes(final ConsultationTypeSearchDTO consultationTypeSearchDTO,
												  @RequestParam(value = "pageNumber", defaultValue = "10", required = false)final Integer pageNumber,
												  @RequestParam(value = "pageSize", defaultValue = "1", required = false)final Integer pageSize,
												  @RequestParam(value = "sort", defaultValue = "idConsultationType", required = false)final String sort);
	
		
	@Operation(summary = "Returns the list of ConsultationTypes", method = "findAllConsultationTypes", description = "Returns the list of ConsultationType")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of ConsultationTypes returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/consultationTypesall", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<ConsultationTypeDTO>> findAllConsultationTypes();
}
