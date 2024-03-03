package com.amachi.app.hospitalappservice.repository;

import com.amachi.app.hospitalappservice.dto.search.ProfessionalActivitySearchDTO;
import com.amachi.app.hospitalappservice.entities.ProfessionalActivity;
import com.amachi.app.hospitalappservice.persistance.ProfessionalActivitySpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalActivityRepository extends JpaRepository<ProfessionalActivity, Integer>, JpaSpecificationExecutor<ProfessionalActivity> {
    default Page<ProfessionalActivity> getProfessionalActivities(ProfessionalActivitySearchDTO professionalActivitySearchDTO, Pageable pageable) {
        return findAll(new ProfessionalActivitySpecification(professionalActivitySearchDTO), pageable);
    }
}
