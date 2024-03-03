package com.amachi.app.hospitalappservice.persistance;

import com.amachi.app.hospitalappservice.dto.search.RoomSearchDTO;
import com.amachi.app.hospitalappservice.entities.Room;
import com.amachi.app.hospitalappservice.entities.Room_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class RoomSpecification implements Specification<Room> {

    private transient RoomSearchDTO roomSearchDTO;

    @Override
    public Predicate toPredicate(Root<Room> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (roomSearchDTO.getIdRoom() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Room_.ID_ROOM), roomSearchDTO.getIdRoom()));
        }

        if (roomSearchDTO.getNumberRoom() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Room_.NUMBER_ROOM), roomSearchDTO.getNumberRoom()));
        }

        if(roomSearchDTO.getTypeRoom() != null) {
            predicates.add(criteriaBuilder.like(root.get(Room_.TYPE_ROOM), "%"+roomSearchDTO.getTypeRoom()+"%"));
        }

        if(roomSearchDTO.getUnvailable() != null) {
            predicates.add(criteriaBuilder.isTrue(root.get(Room_.UNAVAILABLE).in(roomSearchDTO.getUnvailable())));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
