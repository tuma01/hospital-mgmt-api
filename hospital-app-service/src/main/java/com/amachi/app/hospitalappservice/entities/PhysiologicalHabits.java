package com.amachi.app.hospitalappservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PHYSIOLOGICAL_HABITS")
public class PhysiologicalHabits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PHYSIOLOGICAL_HABITS")
    private Long idPhysiologicalHabits;

    @Column(name = "NUTRITION", length = 500)
    private String nutrition;

    @Column(name = "URINATION", length = 500)
    private String urination;

    @Column(name = "DEFECATION", length = 500)
    private String defecation;

    @Column(name = "SLEEP", length = 500)
    private String sleep;

    @Column(name = "SEXUALITY", length = 500)
    private String sexuality;

    @Column(name = "ALLERGIES", length = 200)
    private String allergies;
    @Column(name = "ALLERGIC", length = 500)
    private String allergic;

    @Column(name = "SPORT_ACTIVITIES", length = 200)
    private String sportSActivities;

    @Column(name = "OTHERS", length = 200)
    private String others;
}
