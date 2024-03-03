package com.amachi.app.hospitalappservice.mapper;

import com.amachi.app.hospitalappservice.common.mapper.EntityDtoMapper;
import com.amachi.app.hospitalappservice.dto.AddressDTO;
import com.amachi.app.hospitalappservice.entities.Address;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = EntityDtoMapper.class, builder = @Builder(disableBuilder = true))
public interface AddressMapper extends EntityDtoMapper<Address, AddressDTO> {
	
	@Override
	@Mapping(target = "country", source = "country")
	Address toEntity(AddressDTO dto);
	
	@Override
	@Mapping(target = "country", source = "country")
	AddressDTO toDto(Address entity);
}
