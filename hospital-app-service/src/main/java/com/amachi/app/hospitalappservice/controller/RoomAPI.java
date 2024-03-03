package com.amachi.app.hospitalappservice.controller;

import com.amachi.app.hospitalappservice.dto.RoomDTO;
import com.amachi.app.hospitalappservice.dto.search.RoomSearchDTO;
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

@Tag(name = "Rest API for Room in Hospital App", description = "Rest API in Hospital App to CREATE, UPDATE, FETCH and DELETE Room details")
public interface RoomAPI {
	
	@Operation(
			summary = "Retrieve a Room by Id",
			method = "getRoom", description = "Get a Room object by specifying id. The response is Room object")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of Room returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/rooms/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<RoomDTO> getRoom(@Parameter(description = "Return objet Room", required = true) @PathVariable("id") Integer idRoom);

	@Operation(summary = "Create a Room", method = "addRoom", description = "Room Object send as body parameters")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Room created successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@PostMapping(value = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<RoomDTO> addRoom(@Parameter(description = "Créé objet Room", required = true) @Valid @RequestBody RoomDTO roomDTO);
	
	@Operation(summary = "Modify an Room", method = "updateRoom", description = "Modify Room by ID and Room Object send as body parameters")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Room modified successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@PutMapping(value = "/rooms/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<RoomDTO> updateRoom(@Parameter(description = "Modify objet Room", required = true) @PathVariable("id") Integer idRoom, @Valid @RequestBody RoomDTO roomDTO);

	@Operation(summary = "Delete an Room", method = "deleteRoom", description = "Delete Room by ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Delete Room successfully"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Access denied"),
			@ApiResponse(responseCode = "404", description = "Page not found"),
			@ApiResponse(responseCode = "405", description = "Invalid entry"),
			@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@DeleteMapping(value = "/rooms/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object> deleteRoom(@Parameter(description = "Delete objet Room", required = true) @PathVariable("id") Integer idRoom);

	@Operation(summary = "Returns the list of Rooms", method = "getRooms", description = "Returns the list of Rooms")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of Room returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Page<RoomDTO>> getRooms(final RoomSearchDTO roomSearchDTO,
												  @RequestParam(value = "pageNumber", defaultValue = "10", required = false)final Integer pageNumber,
												  @RequestParam(value = "pageSize", defaultValue = "1", required = false)final Integer pageSize,
												  @RequestParam(value = "sort", defaultValue = "idRoom", required = false)final String sort);


	@Operation(summary = "Returns the list of Rooms", method = "findAllRooms", description = "Returns the list of Rooms")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "List of Address returned successfully"),
		@ApiResponse(responseCode = "401", description = "Unauthorized"),
		@ApiResponse(responseCode = "403", description = "Access denied"),
		@ApiResponse(responseCode = "404", description = "Page not found"),
		@ApiResponse(responseCode = "405", description = "Invalid entry"),
		@ApiResponse(responseCode = "500", description = "The server did not respond")
	})
	@GetMapping(value = "/roomsall", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<RoomDTO>> findAllRooms();
}
