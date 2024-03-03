package com.amachi.app.hospitalappservice.mapper;

import com.amachi.app.hospitalappservice.common.mapper.EntityDtoMapper;
import com.amachi.app.hospitalappservice.dto.PatientDTO;
import com.amachi.app.hospitalappservice.entities.Patient;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = EntityDtoMapper.class, builder = @Builder(disableBuilder = true))
public interface PatientMapper extends EntityDtoMapper<Patient, PatientDTO> {

	PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

	@Override
//	@Mapping(target = "patientContacts", source = "patientContacts")
//	@InheritConfiguration(name = "person")
	Patient toEntity(PatientDTO dto);

	@Override
//	@InheritConfiguration(name = "person")
//	@Mapping(target = "patientContacts", source = "patientContacts")
	//@Mapping(target = "dateOfAdmission", source = "dateOfAdmission", dateFormat = "yyyy-MM-dd HH:mm:ss")
	PatientDTO toDto(Patient entity);
}
