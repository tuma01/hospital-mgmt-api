package com.amachi.app.hospitalappservice.repository;

import com.amachi.app.hospitalappservice.dto.search.CountrySearchDTO;
import com.amachi.app.hospitalappservice.entities.Country;
import com.amachi.app.hospitalappservice.persistance.CountrySpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>, JpaSpecificationExecutor<Country> {
    default Page<Country> getCountries(CountrySearchDTO countrySearchDTO, Pageable pageable) {
        return findAll(new CountrySpecification(countrySearchDTO), pageable);
    }

    Page<Country> findByNameLike(String name, Pageable pageable);
}
