package com.amachi.app.hospitalappservice.repository;

import com.amachi.app.hospitalappservice.dto.search.PatientContactSearchDTO;
import com.amachi.app.hospitalappservice.entities.PatientContact;
import com.amachi.app.hospitalappservice.persistance.PatientContactSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientContactRepository extends JpaRepository<PatientContact, Long>, JpaSpecificationExecutor<PatientContact> {

    default Page<PatientContact> getPatientContacts(PatientContactSearchDTO patientContactSearchDTO, Pageable pageable) {
        return findAll(new PatientContactSpecification(patientContactSearchDTO), pageable);
    }
}
