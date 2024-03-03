package com.amachi.app.hospitalappservice.mapper;

import com.amachi.app.hospitalappservice.common.mapper.EntityDtoMapper;
import com.amachi.app.hospitalappservice.dto.ConsultationTypeDTO;
import com.amachi.app.hospitalappservice.entities.ConsultationType;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = EntityDtoMapper.class, builder = @Builder(disableBuilder = true))
public interface ConsultationTypeMapper extends EntityDtoMapper<ConsultationType, ConsultationTypeDTO> {

	ConsultationTypeMapper INSTANCE = Mappers.getMapper(ConsultationTypeMapper.class);
	
	@Override
	ConsultationType toEntity(ConsultationTypeDTO dto);
	
	@Override
	ConsultationTypeDTO toDto(ConsultationType entity);
}
