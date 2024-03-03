package com.amachi.app.hospitalappservice.persistance;

import com.amachi.app.hospitalappservice.dto.search.PatientSearchDTO;
import com.amachi.app.hospitalappservice.entities.Patient;
import com.amachi.app.hospitalappservice.entities.Patient_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PatientSpecification implements Specification<Patient> {

    private transient PatientSearchDTO patientSearchDTO;

    @Override
    public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        if (patientSearchDTO.getIdCard() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Patient_.ID_CARD), patientSearchDTO.getIdCard()));
        }

        if(patientSearchDTO.getFullName() != null) {
            predicates.add(criteriaBuilder.like(root.get(Patient_.FULL_NAME), "%"+patientSearchDTO.getFullName()+"%"));
        }

        if(patientSearchDTO.getFirstName() != null) {
            predicates.add(criteriaBuilder.like(root.get(Patient_.FIRST_NAME), "%"+patientSearchDTO.getFirstName()+"%"));
        }

        if(patientSearchDTO.getLastName() != null) {
            predicates.add(criteriaBuilder.like(root.get(Patient_.LAST_NAME), "%"+patientSearchDTO.getLastName()+"%"));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

//    @Override
//    public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//        return null;
//    }
}
