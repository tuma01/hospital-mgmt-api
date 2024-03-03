package com.amachi.app.hospitalappservice.mapper;

import com.amachi.app.hospitalappservice.common.mapper.EntityDtoMapper;
import com.amachi.app.hospitalappservice.dto.ProfessionalActivityDTO;
import com.amachi.app.hospitalappservice.entities.ProfessionalActivity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = EntityDtoMapper.class, builder = @Builder(disableBuilder = true))
public interface ProfessionalActivityMapper extends EntityDtoMapper<ProfessionalActivity, ProfessionalActivityDTO> {

	ProfessionalActivityMapper INSTANCE = Mappers.getMapper(ProfessionalActivityMapper.class);
	
	@Override
	ProfessionalActivity toEntity(ProfessionalActivityDTO dto);
	
	@Override
	ProfessionalActivityDTO toDto(ProfessionalActivity entity);
}
