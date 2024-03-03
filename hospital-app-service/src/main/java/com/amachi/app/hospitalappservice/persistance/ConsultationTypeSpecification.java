package com.amachi.app.hospitalappservice.persistance;


import com.amachi.app.hospitalappservice.dto.search.ConsultationTypeSearchDTO;
import com.amachi.app.hospitalappservice.entities.ConsultationType;
import com.amachi.app.hospitalappservice.entities.ConsultationType_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
public class ConsultationTypeSpecification implements Specification<ConsultationType> {

    @Autowired
//    private transient ConsultationTypeSearchDTO consultationTypeSearchDTO;
    private transient ConsultationTypeSearchDTO consultationTypeSearchDTO;

    @Override
    public Predicate toPredicate(Root<ConsultationType> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (consultationTypeSearchDTO.getIdConsultationType() != null) {
            predicates.add(criteriaBuilder.equal(root.get(ConsultationType_.ID_CONSULTATION_TYPE), consultationTypeSearchDTO.getIdConsultationType()));
        }

        if(consultationTypeSearchDTO.getName() != null) {
            predicates.add(criteriaBuilder.like(root.get(ConsultationType_.NAME), "%"+consultationTypeSearchDTO.getName()+"%"));
        }

        if(consultationTypeSearchDTO.getDescription() != null) {
            predicates.add(criteriaBuilder.like(root.get(ConsultationType_.DESCRIPTION), "%"+consultationTypeSearchDTO.getDescription()+"%"));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
