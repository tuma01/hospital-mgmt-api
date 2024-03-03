package com.amachi.app.hospitalappservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FAMILY_HISTORY")
public class FamilyHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FAMILY_HISTORY")
    private Long idFamilyHistory;

    @Column(name = "MOTHER", length = 200)
    private String Mother;

    @Column(name = "FATHER", length = 200)
    private String father;

    @Column(name = "HEREDITARY_DISEASES", length = 200)
    private String hereditaryDiseases;
}
