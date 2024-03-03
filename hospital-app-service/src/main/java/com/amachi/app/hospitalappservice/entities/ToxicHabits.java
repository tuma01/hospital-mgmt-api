package com.amachi.app.hospitalappservice.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TOXIC_HABITS")
public class ToxicHabits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TOXIC_HABITS")
    private Long idToxicHabits;

    @Column(name = "ALCOHOL", length = 200)
    private String alcohol;

    @Column(name = "TOBACCO", length = 200)
    private String tobacco;

    @Column(name = "DRUGS", length = 200)
    private String drugs;

    @Column(name = "INFUSIONS", length = 200)
    private String infusions;

    @Column(name = "OTHERS", length = 200)
    private String others;

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
    public static class Nursee extends Person implements Model {

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
}
