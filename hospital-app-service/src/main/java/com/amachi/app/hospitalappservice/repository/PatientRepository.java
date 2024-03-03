package com.amachi.app.hospitalappservice.repository;

import com.amachi.app.hospitalappservice.dto.search.PatientSearchDTO;
import com.amachi.app.hospitalappservice.entities.Patient;
import com.amachi.app.hospitalappservice.persistance.PatientSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, JpaSpecificationExecutor<Patient> {

    default Page<Patient> getPatients(PatientSearchDTO patientSearchDTO, Pageable pageable) {
        return findAll(new PatientSpecification(patientSearchDTO), pageable);
    }
}
