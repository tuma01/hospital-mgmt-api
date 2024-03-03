package com.amachi.app.hospitalappservice.controller;

import com.amachi.app.hospitalappservice.common.controller.BaseController;
import com.amachi.app.hospitalappservice.common.repository.UiOrderToEntityOrderPropertyMapper;
import com.amachi.app.hospitalappservice.dto.ConsultationTypeDTO;
import com.amachi.app.hospitalappservice.dto.search.ConsultationTypeSearchDTO;
import com.amachi.app.hospitalappservice.entities.ConsultationType;
import com.amachi.app.hospitalappservice.mapper.ConsultationTypeMapper;
import com.amachi.app.hospitalappservice.service.ConsultationTypeService;
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
public class ConsultationTypeController extends BaseController<ConsultationType> implements ConsultationTypeAPI {

	private static final String DEFAULT_SORT_BY_ID = AppConstants.DEFAULT_SORT_BY + "ConsultationType";
	private ConsultationTypeService consultationTypeService;
	private ConsultationTypeMapper consultationTypeMapper;
	private UiOrderToEntityOrderPropertyMapper uiOrderToEntityOrderPropertyMapper;

	@Override
	//	@GetMapping(value = "/consultationTypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConsultationTypeDTO> getConsultationType(Integer idConsultationType) {
		final ConsultationType consultationType = consultationTypeService.getConsultationType(idConsultationType);
		return new ResponseEntity<>(consultationTypeMapper.toDto(consultationType), HttpStatus.OK);
	}

	@Override
	//	@PostMapping(value = "/consultationTypes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConsultationTypeDTO> addConsultationType(ConsultationTypeDTO consultationTypeDTO) {
		final ConsultationType consultationType = consultationTypeService.addConsultationType(consultationTypeMapper.toEntity(consultationTypeDTO));
		return new ResponseEntity<>(consultationTypeMapper.toDto(consultationType), HttpStatus.CREATED);
	}

	@Override
	//	@PutMapping(value = "/consultationTypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConsultationTypeDTO> updateConsultationType(Integer idConsultationType, ConsultationTypeDTO consultationTypeDTO) {
		ConsultationType consultationType  = consultationTypeService.updateConsultationType(idConsultationType, consultationTypeMapper.toEntity(consultationTypeDTO));
		return new ResponseEntity<ConsultationTypeDTO>(consultationTypeMapper.toDto(consultationType), HttpStatus.OK);
	}

	@Override
	//	@DeleteMapping(value = "/consultationTypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteConsultationType(Integer idConsultationType) {
		consultationTypeService.deleteConsultationType(idConsultationType);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	//	@GetMapping(value = "/consultationTypes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<ConsultationTypeDTO>> getConsultationTypes(ConsultationTypeSearchDTO consultationTypeSearchDTO, Integer pageNumber, Integer pageSize, String sort) {
		final Page<ConsultationType> pageConsultationType = consultationTypeService.getConsultationTypes(consultationTypeSearchDTO, pageNumber, pageSize, sort);
		return new ResponseEntity<>(convert(pageConsultationType, consultationTypeMapper, uiOrderToEntityOrderPropertyMapper), HttpStatus.OK);
	}

	@Override
	//	@GetMapping(value = "/consultationTypes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ConsultationTypeDTO>> findAllConsultationTypes() {
		List<ConsultationType> consultationTypes = consultationTypeService.findAllConsultationTypes();
		List<ConsultationTypeDTO> consultationTypeDTOs = consultationTypes.stream().map(entity -> consultationTypeMapper.toDto(entity)).collect(Collectors.toList());
		return ResponseEntity.ok(consultationTypeDTOs);
	}

	@Override
	protected Class<ConsultationType> getEntityClass() {
		return ConsultationType.class;
	}
}
