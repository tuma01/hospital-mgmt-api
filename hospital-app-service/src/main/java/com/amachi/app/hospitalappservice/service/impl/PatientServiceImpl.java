package com.amachi.app.hospitalappservice.service.impl;

import com.amachi.app.hospitalappservice.common.exception.HospitalException;
import com.amachi.app.hospitalappservice.common.util.Error;
import com.amachi.app.hospitalappservice.dto.search.PatientSearchDTO;
import com.amachi.app.hospitalappservice.entities.Patient;
import com.amachi.app.hospitalappservice.repository.PatientContactRepository;
import com.amachi.app.hospitalappservice.repository.PatientRepository;
import com.amachi.app.hospitalappservice.service.PatientService;
import com.amachi.app.hospitalappservice.util.AppConstants;
import com.amachi.app.hospitalappservice.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

@AllArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientContactRepository patientContactRepository;
    @Override
    public Patient getPatient(Long id) {
        checkNotNull(id);
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (!patientOptional.isPresent()) {
            throw new HospitalException(Error.OBJECT_NOT_FOUND, id);
        }
        return patientOptional.get();
    }

    @Override
    @Transactional
    public Patient addPatient(Patient patient) {
        checkNotNull(patient);
//        PatientContact patientContact = patient.getPatientContact();
//        if(patientContact != null) {
//            patientContact = patientContactRepository.save(patientContact);
//            patient.setPatientContact(patientContact);
//        }
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        checkNotNull(id);
        if(patientRepository.findById(id).isEmpty()) {
            throw new HospitalException(Error.OBJECT_NOT_FOUND, id);
        }
        patient.setId(id);
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        checkNotNull(id);
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(!patientOptional.isPresent()) {
            return;
        }
        patientRepository.delete(patientOptional.get());
    }

    @Override
    public Page<Patient> getPatients(PatientSearchDTO patientSearchDTO, Integer pageNumber, Integer pageSize, String sort) {
        checkNotNull(patientSearchDTO);
        var sortById = AppConstants.DEFAULT_SORT_BY + Patient.class.getSimpleName();
        Sort sorting  = Sort.by(AppConstants.DEFAULT_SORT_DIRECTION, sort);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, AppUtils.getSort(sort, sortById));
        return patientRepository.getPatients(patientSearchDTO, pageable);
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }
}
