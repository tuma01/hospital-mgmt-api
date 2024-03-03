package com.amachi.app.hospitalappservice.mapper;


import com.amachi.app.hospitalappservice.common.mapper.EntityDtoMapper;
import com.amachi.app.hospitalappservice.dto.CountryDTO;
import com.amachi.app.hospitalappservice.entities.Country;
import com.amachi.app.hospitalappservice.repository.CountryRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(config = EntityDtoMapper.class, builder = @Builder(disableBuilder = true))
public interface CountryMapper extends EntityDtoMapper<Country, CountryDTO> {

	CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
//	@Override
//	Country toEntity(CountryDTO dto);
	
//	@Override
//	CountryDTO toDto(Country entity);
//	@Mapping(target = "codeCountry", source = "codeCountry")
	CountryDTO toDto(Country country, @MappingTarget CountryDTO countryDTO);


//	@Mapping(target = "codeCountry", source = "codeCountry")
	Country toEntity(CountryDTO countryDTO, @MappingTarget Country country,
						  @Context CountryRepository countryRepository);
}
