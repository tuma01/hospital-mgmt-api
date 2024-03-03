package com.amachi.app.hospitalappservice.mapper;

import com.amachi.app.hospitalappservice.common.mapper.EntityDtoMapper;
import com.amachi.app.hospitalappservice.dto.RoomDTO;
import com.amachi.app.hospitalappservice.entities.Room;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = EntityDtoMapper.class, builder = @Builder(disableBuilder = true))
public interface RoomMapper extends EntityDtoMapper<Room, RoomDTO> {

//	RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);
	
	@Override
	Room toEntity(RoomDTO dto);
	
	@Override
	RoomDTO toDto(Room entity);
}