package com.amachi.app.hospitalappservice.controller;

import com.amachi.app.hospitalappservice.common.controller.BaseController;
import com.amachi.app.hospitalappservice.common.repository.UiOrderToEntityOrderPropertyMapper;
import com.amachi.app.hospitalappservice.dto.RoomDTO;
import com.amachi.app.hospitalappservice.dto.search.RoomSearchDTO;
import com.amachi.app.hospitalappservice.entities.Room;
import com.amachi.app.hospitalappservice.mapper.RoomMapper;
import com.amachi.app.hospitalappservice.service.RoomService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class RoomController extends BaseController implements RoomAPI {

	private RoomService roomService;

	private RoomMapper roomMapper;

	private UiOrderToEntityOrderPropertyMapper uiOrderToEntityOrderPropertyMapper;

	@Override
	//	@GetMapping(value = "/rooms/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoomDTO> getRoom(Integer idRoom) {
		final Room room = roomService.getRoom(idRoom);
		return new ResponseEntity<>(roomMapper.toDto(room), HttpStatus.OK);
	}

	@Override
	//	@PostMapping(value = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoomDTO> addRoom(RoomDTO roomDTO) {
		final Room room = roomService.addRoom(roomMapper.toEntity(roomDTO));
		return new ResponseEntity<>(roomMapper.toDto(room), HttpStatus.CREATED);
	}

	@Override
//	@PutMapping(value = "/rooms/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoomDTO> updateRoom(@PathVariable("id") final Integer idRoom, @RequestBody @Valid RoomDTO roomDTO) {
		Room room  = roomService.updateRoom(idRoom, roomMapper.toEntity(roomDTO));
		return new ResponseEntity<RoomDTO>(roomMapper.toDto(room), HttpStatus.OK);
	}

	@Override
	//	@DeleteMapping(value = "/rooms/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteRoom(Integer idRoom) {
		roomService.deleteRoom(idRoom);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	//	@GetMapping(value = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<RoomDTO>> getRooms(RoomSearchDTO roomSearchDTO, Integer pageNumber, Integer pageSize, String sort) {
		final Page<Room> pageRoom = roomService.getRooms(roomSearchDTO, pageNumber, pageSize, sort);
		return new ResponseEntity<>(convert(pageRoom, roomMapper, uiOrderToEntityOrderPropertyMapper), HttpStatus.OK);
	}

	@Override
	//	@GetMapping(value = "/roomsallparams", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RoomDTO>> findAllRooms() {
		List<Room> rooms = roomService.findAllRooms();
		List<RoomDTO> roomDTOs = rooms.stream().map(entity -> roomMapper.toDto(entity)).collect(Collectors.toList());
		return ResponseEntity.ok(roomDTOs);
	}

	@Override
	protected Class getEntityClass() {
		return Room.class;
	}
}
