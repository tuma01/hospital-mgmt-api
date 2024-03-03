package com.amachi.app.hospitalappservice.service;

import com.amachi.app.hospitalappservice.dto.search.AddressSearchDTO;
import com.amachi.app.hospitalappservice.entities.Address;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
	
	Address getAddress(final Long idAddress);
	
	Address addAddress(final Address address);
	
	Address updateAddress(final Long idAddress, final Address address);
	
	void deleteAddress(final Long idAddress);
	
	Page<Address> getAddresses(final AddressSearchDTO addressSearchDTO, final Integer pageNumber, final Integer pageSize, final String sort);
	
	List<Address> findAllAddresses();

}
