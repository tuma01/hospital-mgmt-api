package com.amachi.app.hospitalappservice.controller;

import com.amachi.app.hospitalappservice.common.controller.BaseController;
import com.amachi.app.hospitalappservice.common.repository.UiOrderToEntityOrderPropertyMapper;
import com.amachi.app.hospitalappservice.dto.PatientDTO;
import com.amachi.app.hospitalappservice.dto.search.PatientSearchDTO;
import com.amachi.app.hospitalappservice.entities.Patient;
import com.amachi.app.hospitalappservice.mapper.PatientMapper;
import com.amachi.app.hospitalappservice.service.PatientService;
import com.amachi.app.hospitalappservice.util.AppConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class PatientController extends BaseController<Patient> implements PatientAPI {

	private static final String DEFAULT_SORT_BY_ID = AppConstants.DEFAULT_SORT_BY;
	private PatientService patientService;
	private PatientMapper patientMapper;
	private UiOrderToEntityOrderPropertyMapper uiOrderToEntityOrderPropertyMapper;


	@Override
	//	@GetMapping(value = "/patients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PatientDTO> getPatient(Long id) {
		final Patient patient = patientService.getPatient(id);
		return new ResponseEntity<>(patientMapper.toDto(patient), HttpStatus.OK);
	}

	@Override
	//	@PostMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PatientDTO> addPatient(PatientDTO patientDTO) {
		final Patient patient = patientService.addPatient(patientMapper.toEntity(patientDTO));
		return new ResponseEntity<>(patientMapper.toDto(patient), HttpStatus.CREATED);
	}

	@Override
	//	@PutMapping(value = "/patients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PatientDTO> updatePatient(Long id, PatientDTO patientDTO) {
		Patient patient  = patientService.updatePatient(id, patientMapper.toEntity(patientDTO));
		return new ResponseEntity<PatientDTO>(patientMapper.toDto(patient), HttpStatus.OK);
	}

	@Override
	//	@DeleteMapping(value = "/patients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deletePatient(Long id) {
		patientService.deletePatient(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	//	@GetMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<PatientDTO>> getPatients(PatientSearchDTO patientSearchDTO, Integer pageNumber, Integer pageSize, String sort) {
		final Page<Patient> pagePatient = patientService.getPatients(patientSearchDTO, pageNumber, pageSize, sort);
		return new ResponseEntity<>(convert(pagePatient, patientMapper, uiOrderToEntityOrderPropertyMapper), HttpStatus.OK);
	}

	@Override
	//	@GetMapping(value = "/patientsAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PatientDTO>> findAllPatients() {
		List<Patient> patients = patientService.findAllPatients();
		List<PatientDTO> patientDTOs = patients.stream().map(entity -> patientMapper.toDto(entity)).collect(Collectors.toList());
		return ResponseEntity.ok(patientDTOs);
	}

	@Override
	protected Class getEntityClass() {
		return null;
	}
}
