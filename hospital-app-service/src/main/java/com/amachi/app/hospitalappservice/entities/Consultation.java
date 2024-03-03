package com.amachi.app.hospitalappservice.entities;

import com.amachi.app.hospitalappservice.common.util.ConsultationStatutEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

//@Entity
@Table(name = "CONSULTATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONSULTATION")
    private Long idConsultation;

    @Column(name = "DESCRIPTION", nullable = false, length = 500)
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ID_CONSULTATION_TYPE", foreignKey = @ForeignKey(name = "FK_CONSULTATION_CONSULTATIONTYPE"))
    private ConsultationType consultationType;

    @Enumerated(EnumType.STRING)
    @Column(name = "CONSULTATION_STATUT")
    private ConsultationStatutEnum consultationStatut;

    @ManyToOne
    @JoinColumn(name = "FK_ID_HOSPITAL", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULTATION_HOSPITAL"))
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "FK_ID_PATIENT", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULTATION_PATIENT"))
    private Patient patient;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ID_DOCTOR_MAKE", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULTATION_DOCTOR_MAKE"))
    private Doctor consultationMakeByDoctor;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ID_DOCTOR_ASKS", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULTATION_DOCTOR_ASKS"))
    private Doctor consultationAsksByDoctor;

    @NotNull
    @Valid
    @JsonProperty("dateConsult")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="CONSULTATION_DATE", length = 7, columnDefinition = "DATE")
    private LocalDate consultationDate;

    @Column(name = "SYMPTOMS")
    private String symptoms;

    @Column(name="reason_consultation", length = 255)
    private String reasonConsultation;

    @Column(name="disease_history", length = 255)
    private String diseaseHistory;

    @Column(name = "FRECUENCIA_CARDIACA")
    private Short frecuenciaCardiaca;

    @Column(name = "PRESION_ARTERIAL")
    private Short presionArterial;

    @Column(name = "FRECUENCIA_RESPIRATORIA")
    private Short frecuenciaRespiratoria;

    @Column(name = "SATURACION_PERIFERICA_OXIGENO")
    private Short saturacionPerifericaOxigeno;

    @Column(name = "WEIGHT")
    private BigDecimal weight;

    @Column(name = "HEIGHT")
    private BigDecimal height;

}