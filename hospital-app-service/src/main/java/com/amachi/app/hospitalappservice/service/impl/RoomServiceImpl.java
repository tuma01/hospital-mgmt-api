package com.amachi.app.hospitalappservice.service.impl;

import com.amachi.app.hospitalappservice.common.exception.HospitalException;
import com.amachi.app.hospitalappservice.common.util.Error;
import com.amachi.app.hospitalappservice.dto.search.RoomSearchDTO;
import com.amachi.app.hospitalappservice.entities.Room;
import com.amachi.app.hospitalappservice.repository.RoomRepository;
import com.amachi.app.hospitalappservice.service.RoomService;
import com.amachi.app.hospitalappservice.util.AppConstants;
import com.amachi.app.hospitalappservice.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

@AllArgsConstructor
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Override
    public Room getRoom(Integer idRoom) {
        checkNotNull(idRoom);
        Optional<Room> roomOptional = roomRepository.findById(idRoom);
        if (!roomOptional.isPresent()) {
            throw new HospitalException(Error.OBJECT_NOT_FOUND, idRoom);
        }
        return roomOptional.get();
    }

    @Override
    public Room addRoom(Room room) {
        checkNotNull(room);
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Integer idRoom, Room room) {
        checkNotNull(idRoom);
        if(roomRepository.findById(idRoom).isEmpty()) {
            throw new HospitalException(Error.OBJECT_NOT_FOUND, idRoom);
        }
        room.setIdRoom(idRoom);
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Integer idRoom) {
        checkNotNull(idRoom);
        Optional<Room> roomOptional = roomRepository.findById(idRoom);
        if(!roomOptional.isPresent()) {
            return;
        }
        roomRepository.delete(roomOptional.get());
    }

    @Override
    public Page<Room> getRooms(RoomSearchDTO roomSearchDTO, Integer pageNumber, Integer pageSize, String sort) {
        checkNotNull(roomSearchDTO);
        var sortById = AppConstants.DEFAULT_SORT_BY + Room.class.getSimpleName();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, AppUtils.getSort(sort, sortById));
        return roomRepository.getCountries(roomSearchDTO, pageable);
    }

    @Override
    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }
}
