package com.amachi.app.hospitalappservice.service;

import com.amachi.app.hospitalappservice.dto.search.ConsultationTypeSearchDTO;
import com.amachi.app.hospitalappservice.entities.ConsultationType;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsultationTypeService {
	
	ConsultationType getConsultationType(final Integer idConsultationType);
	
	ConsultationType addConsultationType(final ConsultationType consultationType);
	
	ConsultationType updateConsultationType(final Integer idConsultationType, final ConsultationType consultationType);
	
	void deleteConsultationType(final Integer idConsultationType);
	
	Page<ConsultationType> getConsultationTypes(final ConsultationTypeSearchDTO consultationTypeSearchDTO, final Integer pageNumber, final Integer pageSize, final String sort);
	
	List<ConsultationType> findAllConsultationTypes();

}
