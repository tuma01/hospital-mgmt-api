package com.amachi.app.hospitalappservice.repository;

import com.amachi.app.hospitalappservice.dto.search.RoomSearchDTO;
import com.amachi.app.hospitalappservice.entities.Room;
import com.amachi.app.hospitalappservice.persistance.RoomSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>, JpaSpecificationExecutor<Room> {
//public interface CountryRepository extends JpaSpecExecRepository<Country, Integer>, EntityManagerRepository {

    default Page<Room> getCountries(RoomSearchDTO roomSearchDTO, Pageable pageable) {
        return findAll(new RoomSpecification(roomSearchDTO), pageable);
    }
}
