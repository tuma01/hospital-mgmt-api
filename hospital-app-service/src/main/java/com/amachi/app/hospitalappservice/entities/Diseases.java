package com.amachi.app.hospitalappservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DISEASES")
public class Diseases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISEASES", nullable = false)
    private Long idDiseases;

//    private MedicalHistory medicalHistory;

    @Column(name = "CARDIOVASCULAR", length = 500)
    private String cardiovascular;

    @Column(name = "RESPIRATORY", length = 500)
    private String respiratory;

    @Column(name = "GASTROINTESTINAL", length = 500)
    private String gastrointestinal;

    @Column(name = "NEPHROUROLOGY", length = 500)
    private String nephrourology;

    @Column(name = "NEUROLOGICAL", length = 500)
    private String neurological;

    @Column(name = "HEMATOLOGICAL", length = 500)
    private String hematological;

    @Column(name = "GYNECOLOGICAL", length = 500)
    private String gynecological;

    @Column(name = "INFECTIOUS", length = 500)
    private String infectious;

    @Column(name = "ENDOCRINOLOGICAL", length = 500)
    private String endocrinological;

    @Column(name = "SURGICAL", length = 500)
    private String surgical;

    @Column(name = "TRAUMATOLOGICAL", length = 500)
    private String traumatological;

    @Column(name = "ALLERGIC", length = 500)
    private String allergic;

    @Column(name = "EPIDEMIOLOGICAL", length = 500)
    private String epidemiological;


    @Column(name = "OTHERS", length = 500)
    private String others;
}
