package com.amachi.app.hospitalappservice.service;

import com.amachi.app.hospitalappservice.dto.search.CountrySearchDTO;
import com.amachi.app.hospitalappservice.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {
	
	Country getCountry(final Integer idCountry);
	
	Country addCountry(final Country country);
	
	Country updateCountry(final Integer idCountry, final Country country);
	
	void deleteCountry(final Integer idCountry);
	
	Page<Country> getCountries(final CountrySearchDTO countrySearchDTO, final Integer pageNumber, final Integer pageSize,  final String sort);
	
	List<Country> findAllCountries();
}
