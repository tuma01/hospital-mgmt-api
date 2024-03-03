package com.amachi.app.hospitalappservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MEDICAL_HISTORY")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MEDICAL_CONSULTATION")
    private Long idMedicalHistory;

    @ManyToOne
    @JoinColumn(name = "FK_ID_PATIENT", nullable = false, foreignKey = @ForeignKey(name = "FK_MEDICALHISTORY_PATIENT"))
    private Patient patient;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ID_PERSONAL_HISTORY", foreignKey = @ForeignKey(name = "FK_MEDICALHISTORY_PERSONALHISTORY"))
    private PersonalHistory personalHistory;

    private String childhoodDisease;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ID_DISEASES", foreignKey = @ForeignKey(name = "FK_MEDICALHISTORY_DISEASES"))
    private Diseases diseases;


//    @ManyToOne
//    @JoinColumn(name = "FK_ID_HOSPITAL", nullable = false, foreignKey = @ForeignKey(name = "FK_MEDICALHISTORY_HOSPITAL"))
//    private Hospital hospital;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "ADMISSION_DATE", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate admissionDate;

    @Column(name = "BLOOD_GROUP")
    private String bloodGroup;

    @Column(name = "REASON_CONSULTATION")
    private String reasonConsultation;

    @Column(name = "CURRENT_DISEASE")  // ENFERMEDAD ACTUAL
    private String currentDisease;

    private String historyCurrentDisease;

    private String familyMedicalHistory;



    @Column(name = "WEIGHT", length = 3)
    private BigDecimal weight;

    @Column(name = "HEIGHT", length = 3)
    private BigDecimal height;
}
