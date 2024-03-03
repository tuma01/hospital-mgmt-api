package com.amachi.app.hospitalappservice.service.impl;

import com.amachi.app.hospitalappservice.common.exception.HospitalException;
import com.amachi.app.hospitalappservice.common.util.Error;
import com.amachi.app.hospitalappservice.dto.search.CountrySearchDTO;
import com.amachi.app.hospitalappservice.entities.Country;
import com.amachi.app.hospitalappservice.repository.CountryRepository;
import com.amachi.app.hospitalappservice.service.CountryService;
import com.amachi.app.hospitalappservice.util.AppConstants;
import com.amachi.app.hospitalappservice.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;


@AllArgsConstructor
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country getCountry(Integer idCountry) {
        checkNotNull(idCountry);
        Optional<Country> countryOptional = countryRepository.findById(idCountry);
        if (!countryOptional.isPresent()) {
            throw new HospitalException(Error.OBJECT_NOT_FOUND, idCountry);
        }
        return countryOptional.get();
    }

    @Override
    public Country addCountry(Country country) {
        checkNotNull(country);
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Integer idCountry, Country country) {
        checkNotNull(idCountry);
        if (countryRepository.findById(idCountry).isEmpty()) {
            throw new HospitalException(Error.OBJECT_NOT_FOUND, idCountry);
        }
        country.setIdCountry(idCountry);
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Integer idCountry) {
        checkNotNull(idCountry);
        Optional<Country> countryOptional = countryRepository.findById(idCountry);
        if (!countryOptional.isPresent()) {
            return;
        }
        countryRepository.delete(countryOptional.get());
    }

    @Override
    public Page<Country> getCountries(CountrySearchDTO countrySearchDTO, Integer pageNumber, Integer pageSize, String sort) {
        checkNotNull(countrySearchDTO);
        var sortById = AppConstants.DEFAULT_SORT_BY + Country.class.getSimpleName();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, AppUtils.getSort(sort, sortById));
        return countryRepository.getCountries(countrySearchDTO, pageable);
    }

    @Override
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }
}
