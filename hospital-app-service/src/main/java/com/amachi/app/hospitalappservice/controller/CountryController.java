package com.amachi.app.hospitalappservice.controller;

import com.amachi.app.hospitalappservice.common.controller.BaseController;
import com.amachi.app.hospitalappservice.common.exception.NoParametersProvidedException;
import com.amachi.app.hospitalappservice.common.repository.UiOrderToEntityOrderPropertyMapper;
import com.amachi.app.hospitalappservice.dto.CountryDTO;
import com.amachi.app.hospitalappservice.dto.request.GetCountriesRequest;
import com.amachi.app.hospitalappservice.dto.search.CountrySearchDTO;
import com.amachi.app.hospitalappservice.entities.Country;
import com.amachi.app.hospitalappservice.mapper.CountryMapper;
import com.amachi.app.hospitalappservice.service.CountryService;
import com.amachi.app.hospitalappservice.util.RequestValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class CountryController extends BaseController<Country> implements CountryAPI {

	private CountryService countrylService;
	private CountryMapper countryMapper;
	private UiOrderToEntityOrderPropertyMapper uiOrderToEntityOrderPropertyMapper;

	RequestValidator requestValidator;

	@Override
	public ResponseEntity<CountryDTO> getCountry(Integer idCountry) {
		final var country = countrylService.getCountry(idCountry);
		return new ResponseEntity<>(countryMapper.toDto(country), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CountryDTO> addCountry(CountryDTO countryDTO) {
		final var country = countrylService.addCountry(countryMapper.toEntity(countryDTO));
		return new ResponseEntity<>(countryMapper.toDto(country), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<CountryDTO> updateCountry(Integer idCountry, CountryDTO countryDTO) {
		var country  = countrylService.updateCountry(idCountry, countryMapper.toEntity(countryDTO));
		return new ResponseEntity<CountryDTO>(countryMapper.toDto(country), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteCountry(@PathVariable("id") final Integer idCountry) {
		countrylService.deleteCountry(idCountry);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	//	@GetMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<CountryDTO>> getCountries(CountrySearchDTO countrySearchDTO, Integer pageNumber, Integer pageSize, String sort) {
		final Page<Country> pageCountry = countrylService.getCountries(countrySearchDTO, pageNumber, pageSize, sort);
		return new ResponseEntity<>(convert(pageCountry, countryMapper, uiOrderToEntityOrderPropertyMapper), HttpStatus.OK);
	}

	@Override
	//	@GetMapping(value = "/countriesall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CountryDTO>> findAllCountries() {
//		log.info("/countriesall request received: {}", getCountriesRequest);
//		requestValidator.validateGetCountriesRequest(getCountriesRequest);
		log.info("/countriesall request received");
		List<Country> countries = countrylService.findAllCountries();
		List<CountryDTO> countryDTOs = countries.stream().map(entity -> countryMapper.toDto(entity)).collect(Collectors.toList());
		return ResponseEntity.ok(countryDTOs);
	}

	@Override
	protected Class getEntityClass() {
		return Country.class;
	}
}
