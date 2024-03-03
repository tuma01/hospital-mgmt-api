package com.amachi.app.hospitalappservice.service.impl;

import com.amachi.app.hospitalappservice.common.exception.HospitalException;
import com.amachi.app.hospitalappservice.common.util.Error;
import com.amachi.app.hospitalappservice.dto.search.ConsultationTypeSearchDTO;
import com.amachi.app.hospitalappservice.entities.ConsultationType;
import com.amachi.app.hospitalappservice.repository.ConsultationTypeRepository;
import com.amachi.app.hospitalappservice.service.ConsultationTypeService;
import com.amachi.app.hospitalappservice.util.AppConstants;
import com.amachi.app.hospitalappservice.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

@AllArgsConstructor
@Service
public class ConsultationTypeServiceImpl implements ConsultationTypeService {
    @Autowired
    ConsultationTypeRepository consultationTypeRepository;
    @Override
    public ConsultationType getConsultationType(Integer idConsultationType) {
        checkNotNull(idConsultationType);
        Optional<ConsultationType> consultationTypeOptional = consultationTypeRepository.findById(idConsultationType);
        if (!consultationTypeOptional.isPresent()) {
            throw new HospitalException(Error.OBJECT_NOT_FOUND, idConsultationType);
        }
        return consultationTypeOptional.get();
    }

    @Override
    public ConsultationType addConsultationType(ConsultationType consultationType) {
        checkNotNull(consultationType);
        return consultationTypeRepository.save(consultationType);
    }

    @Override
    public ConsultationType updateConsultationType(Integer idConsultationType, ConsultationType consultationType) {
        checkNotNull(idConsultationType);
        if(consultationTypeRepository.findById(idConsultationType).isEmpty()) {
            throw new HospitalException(Error.OBJECT_NOT_FOUND, idConsultationType);
        }
        consultationType.setIdConsultationType(idConsultationType);
        return consultationTypeRepository.save(consultationType);
    }

    @Override
    public void deleteConsultationType(Integer idConsultationType) {
        checkNotNull(idConsultationType);
        Optional<ConsultationType> consultationTypeOptional = consultationTypeRepository.findById(idConsultationType);
        if(!consultationTypeOptional.isPresent()) {
            return;
        }
        consultationTypeRepository.delete(consultationTypeOptional.get());
    }

    @Override
    public Page<ConsultationType> getConsultationTypes(ConsultationTypeSearchDTO consultationTypeSearchDTO, Integer pageNumber, Integer pageSize, String sort) {
        checkNotNull(consultationTypeSearchDTO);
        var sortById = AppConstants.DEFAULT_SORT_BY + ConsultationType.class.getSimpleName();
        Sort sorting  = Sort.by(AppConstants.DEFAULT_SORT_DIRECTION, sort);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, AppUtils.getSort(sort, sortById));
        return consultationTypeRepository.getConsultationTypes(consultationTypeSearchDTO, pageable);
    }

    @Override
    public List<ConsultationType> findAllConsultationTypes() {
        return consultationTypeRepository.findAll();
    }
}
