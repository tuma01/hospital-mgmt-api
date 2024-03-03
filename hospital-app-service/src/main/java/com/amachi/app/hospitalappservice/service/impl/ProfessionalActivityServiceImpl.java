package com.amachi.app.hospitalappservice.service.impl;

import com.amachi.app.hospitalappservice.common.exception.HospitalException;
import com.amachi.app.hospitalappservice.common.util.Error;
import com.amachi.app.hospitalappservice.dto.search.ProfessionalActivitySearchDTO;
import com.amachi.app.hospitalappservice.entities.ProfessionalActivity;
import com.amachi.app.hospitalappservice.repository.ProfessionalActivityRepository;
import com.amachi.app.hospitalappservice.service.ProfessionalActivityService;
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
public class ProfessionalActivityServiceImpl implements ProfessionalActivityService {
    @Autowired
    ProfessionalActivityRepository professionalActivityRepository;
    @Override
    public ProfessionalActivity getProfessionalActivity(Integer idProfessionalActivity) {
        checkNotNull(idProfessionalActivity);
        Optional<ProfessionalActivity> professionalActivityOptional = professionalActivityRepository.findById(idProfessionalActivity);
        if (!professionalActivityOptional.isPresent()) {
            throw new HospitalException(Error.OBJECT_NOT_FOUND, idProfessionalActivity);
        }
        return professionalActivityOptional.get();
    }

    @Override
    public ProfessionalActivity addProfessionalActivity(ProfessionalActivity professionalActivity) {
        checkNotNull(professionalActivity);
        return professionalActivityRepository.save(professionalActivity);
    }

    @Override
    public ProfessionalActivity updateProfessionalActivity(Integer idProfessionalActivity, ProfessionalActivity professionalActivity) {
        checkNotNull(idProfessionalActivity);
        if(professionalActivityRepository.findById(idProfessionalActivity).isEmpty()) {
            throw new HospitalException(Error.OBJECT_NOT_FOUND, idProfessionalActivity);
        }
        professionalActivity.setIdProfessionalActivity(idProfessionalActivity);
        return professionalActivityRepository.save(professionalActivity);
    }

    @Override
    public void deleteProfessionalActivity(Integer idProfessionalActivity) {
        checkNotNull(idProfessionalActivity);
        Optional<ProfessionalActivity> professionalActivityOptional = professionalActivityRepository.findById(idProfessionalActivity);
        if(!professionalActivityOptional.isPresent()) {
            return;
        }
        professionalActivityRepository.delete(professionalActivityOptional.get());
    }

    @Override
    public Page<ProfessionalActivity> getProfessionalActivities(ProfessionalActivitySearchDTO professionalActivitySearchDTO, Integer pageNumber, Integer pageSize, String sort) {
        checkNotNull(professionalActivitySearchDTO);
        var sortById = AppConstants.DEFAULT_SORT_BY + ProfessionalActivity.class.getSimpleName();
        Sort sorting  = Sort.by(AppConstants.DEFAULT_SORT_DIRECTION, sort);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, AppUtils.getSort(sort, sortById));
        return professionalActivityRepository.getProfessionalActivities(professionalActivitySearchDTO, pageable);
    }

    @Override
    public List<ProfessionalActivity> findAllProfessionalActivities() {
        return professionalActivityRepository.findAll();
    }
}
