package com.amachi.app.hospitalappservice.controller;

import com.amachi.app.hospitalappservice.common.controller.BaseController;
import com.amachi.app.hospitalappservice.common.repository.UiOrderToEntityOrderPropertyMapper;
import com.amachi.app.hospitalappservice.dto.ProfessionalActivityDTO;
import com.amachi.app.hospitalappservice.dto.search.ProfessionalActivitySearchDTO;
import com.amachi.app.hospitalappservice.entities.ProfessionalActivity;
import com.amachi.app.hospitalappservice.mapper.ProfessionalActivityMapper;
import com.amachi.app.hospitalappservice.service.ProfessionalActivityService;
import com.amachi.app.hospitalappservice.util.AppConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class ProfessionalActivityController extends BaseController implements ProfessionalActivityAPI {

	private static final String DEFAULT_SORT_BY_ID = AppConstants.DEFAULT_SORT_BY + "ProfessionalActivity";
	private ProfessionalActivityService professionalActivityService;
	private ProfessionalActivityMapper professionalActivityMapper;
	private UiOrderToEntityOrderPropertyMapper uiOrderToEntityOrderPropertyMapper;

	@Override
	//	@GetMapping(value = "/professionalActivities/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProfessionalActivityDTO> getProfessionalActivity(Integer idProfessionalActivity) {
		final ProfessionalActivity professionalActivity = professionalActivityService.getProfessionalActivity(idProfessionalActivity);
		return new ResponseEntity<>(professionalActivityMapper.toDto(professionalActivity), HttpStatus.OK);
	}

	@Override
	//	@PostMapping(value = "/professionalActivities", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProfessionalActivityDTO> addProfessionalActivity(ProfessionalActivityDTO professionalActivityDTO) {
		final ProfessionalActivity professionalActivity = professionalActivityService.addProfessionalActivity(professionalActivityMapper.toEntity(professionalActivityDTO));
		return new ResponseEntity<>(professionalActivityMapper.toDto(professionalActivity), HttpStatus.CREATED);
	}

	@Override
	//	@PutMapping(value = "/professionalActivities/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProfessionalActivityDTO> updateProfessionalActivity(Integer idProfessionalActivity, ProfessionalActivityDTO professionalActivityDTO) {
		ProfessionalActivity professionalActivity  = professionalActivityService.updateProfessionalActivity(idProfessionalActivity, professionalActivityMapper.toEntity(professionalActivityDTO));
		return new ResponseEntity<ProfessionalActivityDTO>(professionalActivityMapper.toDto(professionalActivity), HttpStatus.OK);
	}

	@Override
	//	@DeleteMapping(value = "/professionalActivities/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteProfessionalActivity(Integer idProfessionalActivity) {
		professionalActivityService.deleteProfessionalActivity(idProfessionalActivity);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	//	@GetMapping(value = "/professionalActivities", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<ProfessionalActivityDTO>> getProfessionalActivities(ProfessionalActivitySearchDTO professionalActivitySearchDTO, Integer pageNumber, Integer pageSize, String sort) {
		final Page<ProfessionalActivity> pageProfessionalActivity = professionalActivityService.getProfessionalActivities(professionalActivitySearchDTO, pageNumber, pageSize, sort);
		return new ResponseEntity<>(convert(pageProfessionalActivity, professionalActivityMapper, uiOrderToEntityOrderPropertyMapper), HttpStatus.OK);
	}

	@Override
	//	@GetMapping(value = "/professionalActivitiesAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProfessionalActivityDTO>> findAllProfessionalActivities() {
		List<ProfessionalActivity> professionalActivities = professionalActivityService.findAllProfessionalActivities();
		List<ProfessionalActivityDTO> professionalActivityDTOs = professionalActivities.stream().map(entity -> professionalActivityMapper.toDto(entity)).collect(Collectors.toList());
		return ResponseEntity.ok(professionalActivityDTOs);
	}

	@Override
	protected Class getEntityClass() {
		return ProfessionalActivity.class;
	}
}
