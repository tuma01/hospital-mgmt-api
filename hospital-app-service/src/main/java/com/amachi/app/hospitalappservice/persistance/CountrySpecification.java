package com.amachi.app.hospitalappservice.persistance;

import com.amachi.app.hospitalappservice.dto.search.CountrySearchDTO;
import com.amachi.app.hospitalappservice.entities.Country;
import com.amachi.app.hospitalappservice.entities.Country_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CountrySpecification implements Specification<Country> {

    private transient CountrySearchDTO countrySearchDTO;

    @Override
    public Predicate toPredicate(Root<Country> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (countrySearchDTO.getIdCountry() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Country_.ID_COUNTRY), countrySearchDTO.getIdCountry()));
        }

        if (countrySearchDTO.getName() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Country_.NAME), countrySearchDTO.getName()));
        }

        if (countrySearchDTO.getIso() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Country_.ISO), countrySearchDTO.getIso()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
