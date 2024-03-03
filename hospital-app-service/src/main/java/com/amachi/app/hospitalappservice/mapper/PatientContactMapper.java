package com.amachi.app.hospitalappservice.mapper;

import com.amachi.app.hospitalappservice.common.mapper.EntityDtoMapper;
import com.amachi.app.hospitalappservice.dto.PatientContactDTO;
import com.amachi.app.hospitalappservice.entities.PatientContact;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = EntityDtoMapper.class, builder = @Builder(disableBuilder = true))
public interface PatientContactMapper extends EntityDtoMapper<PatientContact, PatientContactDTO> {

	PatientContactMapper INSTANCE = Mappers.getMapper(PatientContactMapper.class);

	@Override
//	@Mapping(target = "professionalActivity", source = "professionalActivity")
//	@Mapping(target = "dateOfAdmission", source = "dateOfAdmission", dateFormat = "yyyy-MM-dd HH:mm:ss")
	PatientContact toEntity(PatientContactDTO dto);

	@Override
//	@InheritConfiguration(name = "person")
	PatientContactDTO toDto(PatientContact entity);
}
