package com.amachi.app.hospitalappservice.repository;

import com.amachi.app.hospitalappservice.dto.search.ConsultationTypeSearchDTO;
import com.amachi.app.hospitalappservice.entities.ConsultationType;
import com.amachi.app.hospitalappservice.persistance.ConsultationTypeSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationTypeRepository extends JpaRepository<ConsultationType, Integer>, JpaSpecificationExecutor<ConsultationType> {
    default Page<ConsultationType> getConsultationTypes(ConsultationTypeSearchDTO consultationTypeSearchDTO, Pageable pageable) {
        return findAll(new ConsultationTypeSpecification(consultationTypeSearchDTO), pageable);
    }
}
