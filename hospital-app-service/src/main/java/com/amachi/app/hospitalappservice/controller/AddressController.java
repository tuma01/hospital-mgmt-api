package com.amachi.app.hospitalappservice.controller;

import com.amachi.app.hospitalappservice.common.controller.BaseController;
import com.amachi.app.hospitalappservice.common.repository.UiOrderToEntityOrderPropertyMapper;
import com.amachi.app.hospitalappservice.dto.AddressDTO;
import com.amachi.app.hospitalappservice.dto.search.AddressSearchDTO;
import com.amachi.app.hospitalappservice.entities.Address;
import com.amachi.app.hospitalappservice.mapper.AddressMapper;
import com.amachi.app.hospitalappservice.service.AddressService;
import com.amachi.app.hospitalappservice.util.AppConstants;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class AddressController extends BaseController implements AddressAPI {

	private AddressService addressService;

	private AddressMapper addressMapper;

	private UiOrderToEntityOrderPropertyMapper uiOrderToEntityOrderPropertyMapper;

	@Override
//	@GetMapping(value = "/addresses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AddressDTO> getAddress(@PathVariable("id") final Long idAddress) {
		final var address = addressService.getAddress(idAddress);
		return new ResponseEntity<>(addressMapper.toDto(address), HttpStatus.OK);
	}

	@Override
	//	@PostMapping(value = "/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AddressDTO> addAddress(@Valid AddressDTO addressDTO) {
		final Address address = addressService.addAddress(addressMapper.toEntity(addressDTO));
		return new ResponseEntity<>(addressMapper.toDto(address), HttpStatus.CREATED);
	}

	@Override
//	@PutMapping(value = "/addresses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AddressDTO> updateAddress(@PathVariable("id") final Long idAddress, @RequestBody @Valid AddressDTO addressDTO) {
		var address  = addressService.updateAddress(idAddress, addressMapper.toEntity(addressDTO));
		return new ResponseEntity<AddressDTO>(addressMapper.toDto(address), HttpStatus.OK);
	}

	@Override
//	@DeleteMapping(value = "/addresses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteAddress(@PathVariable("id") final Long idAddress) {
		addressService.deleteAddress(idAddress);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
//	@GetMapping(value = "/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<AddressDTO>> getAddresses(final AddressSearchDTO addressSearchDTO,
														 @RequestParam(value = "pageNumber", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) final Integer pageNumber,
														 @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) final Integer pageSize,
														 @RequestParam(value = "sort", required = false) final String sort) {
		final Page<Address> pageAddress = addressService.getAddresses(addressSearchDTO, pageNumber, pageSize, sort);
		return new ResponseEntity<>(convert(pageAddress, addressMapper, uiOrderToEntityOrderPropertyMapper), HttpStatus.OK);
	}

	@Override
//	@GetMapping(value = "/addressesall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AddressDTO>> findAllAddresses() {
		List<Address> addresses = addressService.findAllAddresses();
		List<AddressDTO> addressDTOs = addresses.stream().map(entity -> addressMapper.toDto(entity)).collect(Collectors.toList());
		return ResponseEntity.ok(addressDTOs);
	}

	@Override
	protected Class getEntityClass() {
		return Address.class;
	}
}
