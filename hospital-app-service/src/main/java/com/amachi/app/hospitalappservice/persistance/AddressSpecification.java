package com.amachi.app.hospitalappservice.persistance;

import com.amachi.app.hospitalappservice.dto.search.AddressSearchDTO;
import com.amachi.app.hospitalappservice.entities.Address;
import com.amachi.app.hospitalappservice.entities.Address_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
public class AddressSpecification implements Specification<Address> {
//    @Autowired
    public AddressSearchDTO addressSearchDTO;


//    public AddressSpecification(AddressSearchDTO addressSearchDTO) {
//        this.addressSearchDTO = addressSearchDTO1;
//    }

    @Override
    public Predicate toPredicate(Root<Address> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (addressSearchDTO.getIdAddress() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Address_.ID_ADDRESS), addressSearchDTO.getIdAddress()));
        }

        if(addressSearchDTO.getAddress1() != null) {
            predicates.add(criteriaBuilder.like(root.get(Address_.ADDRESS1), "%"+addressSearchDTO.getAddress1()+"%"));
        }

        if(addressSearchDTO.getCity() != null) {
            predicates.add(criteriaBuilder.like(root.get(Address_.CITY), "%"+addressSearchDTO.getCity()+"%"));
        }

        if(addressSearchDTO.getPostalCode() != null) {
            predicates.add(criteriaBuilder.like(root.get(Address_.POSTAL_CODE), "%"+addressSearchDTO.getPostalCode()+"%"));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
