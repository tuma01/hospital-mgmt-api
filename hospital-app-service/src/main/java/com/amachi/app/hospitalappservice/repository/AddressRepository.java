package com.amachi.app.hospitalappservice.repository;

import com.amachi.app.hospitalappservice.dto.search.AddressSearchDTO;
import com.amachi.app.hospitalappservice.entities.Address;
import com.amachi.app.hospitalappservice.persistance.AddressSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>, JpaSpecificationExecutor<Address> {

    default Page<Address> getAddreses(AddressSearchDTO addressSearchDTO, Pageable pageable) {
        return findAll(new AddressSpecification(addressSearchDTO), pageable);
    }
}
