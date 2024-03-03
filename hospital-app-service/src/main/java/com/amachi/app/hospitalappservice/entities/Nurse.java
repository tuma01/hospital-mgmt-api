package com.amachi.app.hospitalappservice.entities;

import com.amachi.app.hospitalappservice.entities.Hospital;
import com.amachi.app.hospitalappservice.entities.Model;
import com.amachi.app.hospitalappservice.entities.Person;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=true)
@SuperBuilder(toBuilder = true) // ,buildMethodName = "buildInternal"
@Entity
@Table(name = "NURSE")
@DiscriminatorValue("nurse")
@PrimaryKeyJoinColumn( name = "id" )
public class Nurse extends Person implements Model {

    @Lob
    @Column(name = "PHOTO", columnDefinition = "mediumblob")
    private Blob photo;

    @Column(name = "ID_CARD", unique = true, length = 100)
    private String idCard;

//    @ManyToMany(mappedBy = "nurses")
//    private Set<Hospital> hospitals;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            })
//    @JoinTable(name = "HOSPITAL_NURSE",
//            joinColumns = { @JoinColumn(name = "ID_HOSPITAL") },
//            inverseJoinColumns = { @JoinColumn(name = "ID_NURSE") })
//    private Set<Hospital> hospitals = new HashSet<>();

    @ManyToMany(mappedBy = "nurses")
    private Set<Hospital> hospitals = new HashSet<>();


}
