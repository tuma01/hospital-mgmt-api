package com.amachi.app.hospitalappservice.service;

import com.amachi.app.hospitalappservice.dto.search.RoomSearchDTO;
import com.amachi.app.hospitalappservice.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {
	
	Room getRoom(final Integer idRoom);
	
	Room addRoom(final Room room);
	
	Room updateRoom(final Integer idRoom, final Room room);
	
	void deleteRoom(final Integer idRoom);
	
	Page<Room> getRooms(final RoomSearchDTO roomSearchDTO,final Integer pageNumber, final Integer pageSize, final String sort);
	
	List<Room> findAllRooms();

}
