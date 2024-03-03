package com.amachi.app.hospitalappservice.mapper;

import com.amachi.app.hospitalappservice.common.mapper.EntityDtoMapper;
import com.amachi.app.hospitalappservice.dto.HospitalDTO;
import com.amachi.app.hospitalappservice.dto.PatientDTO;
import com.amachi.app.hospitalappservice.entities.Hospital;
import com.amachi.app.hospitalappservice.entities.Patient;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = EntityDtoMapper.class, builder = @Builder(disableBuilder = true))
public interface HospitalMapper  extends EntityDtoMapper<Hospital, HospitalDTO> {
    HospitalMapper INSTANCE = Mappers.getMapper(HospitalMapper.class);

    @Override
//	@Mapping(target = "patientContacts", source = "patientContacts")
//	@InheritConfiguration(name = "person")
    Hospital toEntity(HospitalDTO dto);

    @Override
//	@InheritConfiguration(name = "person")
//	@Mapping(target = "patientContacts", source = "patientContacts")
        //@Mapping(target = "dateOfAdmission", source = "dateOfAdmission", dateFormat = "yyyy-MM-dd HH:mm:ss")
    HospitalDTO toDto(Hospital entity);
}
