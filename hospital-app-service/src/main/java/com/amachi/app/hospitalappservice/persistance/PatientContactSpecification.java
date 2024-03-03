package com.amachi.app.hospitalappservice.persistance;

import com.amachi.app.hospitalappservice.dto.search.PatientContactSearchDTO;
import com.amachi.app.hospitalappservice.entities.PatientContact;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PatientContactSpecification implements Specification<PatientContact> {

    private transient PatientContactSearchDTO patientContactSearchDTO;

    @Override
    public Predicate toPredicate(Root<PatientContact> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

//        if(patientContactSearchDTO.getFirstName() != null) {
//            predicates.add(criteriaBuilder.like(root.get(PatientContact_.FIRST_NAME), "%"+patientContactSearchDTO.getFirstName()+"%"));
//        }
//
//        if(patientContactSearchDTO.getLastName() != null) {
//            predicates.add(criteriaBuilder.like(root.get(PatientContact_.LAST_NAME), "%"+patientContactSearchDTO.getLastName()+"%"));
//        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
