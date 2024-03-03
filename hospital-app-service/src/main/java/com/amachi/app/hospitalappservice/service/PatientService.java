package com.amachi.app.hospitalappservice.service;

import com.amachi.app.hospitalappservice.dto.search.PatientSearchDTO;
import com.amachi.app.hospitalappservice.entities.Patient;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PatientService {

    Patient getPatient(final Long id);

    Patient addPatient(final Patient patient);

    Patient updatePatient(final Long id, final Patient patient);

    void deletePatient(final Long id);

    Page<Patient> getPatients(final PatientSearchDTO patientSearchDTO, final Integer pageNumber, final Integer pageSize, final String sort);

    List<Patient> findAllPatients();

}
