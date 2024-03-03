package com.amachi.app.hospitalappservice.service.impl;

import com.amachi.app.hospitalappservice.common.exception.HospitalException;
import com.amachi.app.hospitalappservice.common.util.Error;
import com.amachi.app.hospitalappservice.dto.search.AddressSearchDTO;
import com.amachi.app.hospitalappservice.entities.Address;
import com.amachi.app.hospitalappservice.entities.Country;
import com.amachi.app.hospitalappservice.repository.AddressRepository;
import com.amachi.app.hospitalappservice.repository.CountryRepository;
import com.amachi.app.hospitalappservice.service.AddressService;
import com.amachi.app.hospitalappservice.util.AppConstants;
import com.amachi.app.hospitalappservice.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

	AddressRepository addressRepository;

	CountryRepository countryRepository;
	@Override
	public Address getAddress(Long idAddress) {
		checkNotNull(idAddress);
		Optional<Address> addressOptional = addressRepository.findById(idAddress);
		if (addressOptional.isEmpty()) {
			throw new HospitalException(Error.OBJECT_NOT_FOUND, idAddress);
		}
		return addressOptional.get();
	}

	@Override
	public Address addAddress(Address address) {
		Country country = address.getCountry();
		Optional<Country> countryOptional = countryRepository.findById(country.getIdCountry());
		if (countryOptional.isEmpty()) {
			throw new HospitalException(Error.OBJECT_NOT_FOUND, country.getIdCountry());
		}
		checkNotNull(address);
		address.setCountry(countryOptional.get());
		return addressRepository.save(address);
	}

	@Override
	public Address updateAddress(Long idAddress, Address address) {
		checkNotNull(idAddress);
		if(addressRepository.findById(idAddress).isEmpty()) {
			throw new HospitalException(Error.OBJECT_NOT_FOUND, idAddress);
		}
		address.setIdAddress(idAddress);
		return addressRepository.save(address);
	}

	@Override
	public void deleteAddress(Long idAddress) {
		checkNotNull(idAddress);
		Optional<Address> addressOptional = addressRepository.findById(idAddress);
		if(addressOptional.isEmpty()) {
			return;
		}
		addressRepository.deleteById(idAddress);
	}

	@Override
	public Page<Address> getAddresses(AddressSearchDTO addressSearchDTO, Integer pageNumber, Integer pageSize, String sort) {
		checkNotNull(addressSearchDTO);
		var sortById = AppConstants.DEFAULT_SORT_BY + Address.class.getSimpleName();
		Pageable pageable = PageRequest.of(pageNumber, pageSize, AppUtils.getSort(sort, sortById));
		return addressRepository.getAddreses(addressSearchDTO, pageable);
	}

	@Override
	public List<Address> findAllAddresses() {
		return addressRepository.findAll();
	}
}
