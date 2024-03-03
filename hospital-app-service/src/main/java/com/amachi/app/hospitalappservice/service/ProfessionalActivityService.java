package com.amachi.app.hospitalappservice.service;

import com.amachi.app.hospitalappservice.dto.search.ProfessionalActivitySearchDTO;
import com.amachi.app.hospitalappservice.entities.ProfessionalActivity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProfessionalActivityService {

    ProfessionalActivity getProfessionalActivity(final Integer idProfessionalActivity);

    ProfessionalActivity addProfessionalActivity(final ProfessionalActivity professionalActivity);

    ProfessionalActivity updateProfessionalActivity(final Integer idProfessionalActivity, final ProfessionalActivity professionalActivity);

    void deleteProfessionalActivity(final Integer idProfessionalActivity);

    Page<ProfessionalActivity> getProfessionalActivities(final ProfessionalActivitySearchDTO professionalActivitySearchDTO, final Integer pageNumber, final Integer pageSize, final String sort);

    List<ProfessionalActivity> findAllProfessionalActivities();

}
