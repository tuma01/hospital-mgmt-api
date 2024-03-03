package com.amachi.app.hospitalappservice.persistance;

import com.amachi.app.hospitalappservice.dto.search.ProfessionalActivitySearchDTO;
import com.amachi.app.hospitalappservice.entities.ProfessionalActivity;
import com.amachi.app.hospitalappservice.entities.ProfessionalActivity_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ProfessionalActivitySpecification implements Specification<ProfessionalActivity> {

    private transient ProfessionalActivitySearchDTO professionalActivitySearchDTO;

    @Override
    public Predicate toPredicate(Root<ProfessionalActivity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        if (professionalActivitySearchDTO.getIdProfessionalActivity() != null) {
            predicates.add(criteriaBuilder.equal(root.get(ProfessionalActivity_.ID_PROFESSIONAL_ACTIVITY), professionalActivitySearchDTO.getIdProfessionalActivity()));
        }

        if(professionalActivitySearchDTO.getName() != null) {
            predicates.add(criteriaBuilder.like(root.get(ProfessionalActivity_.NAME), "%"+professionalActivitySearchDTO.getName()+"%"));
        }

        if(professionalActivitySearchDTO.getDescription() != null) {
            predicates.add(criteriaBuilder.like(root.get(ProfessionalActivity_.DESCRIPTION), "%"+professionalActivitySearchDTO.getDescription()+"%"));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
