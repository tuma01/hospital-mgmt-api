package com.amachi.app.hospitalappservice.entities;

import com.amachi.app.hospitalappservice.common.util.GenderEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
////@EqualsAndHashCode(callSuper=true)
//@SuperBuilder(toBuilder = true) // ,buildMethodName = "buildInternal"
//@Entity
//@Table(name = "PATIENT_CONTACT")
//@DiscriminatorValue("patient_contact")
//@PrimaryKeyJoinColumn( name = "id" )
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
@Builder
@Entity
@Table(name = "PATIENT_CONTACT")
public class PatientContact implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PATIENT_CONTACT")
    private Long idPatientContact;

    @Column(name = "FIRSTNAME", length = 50, nullable = false)
    @NotNull
    @NotBlank(message = "firstName is required")
    @Size(min = 3, max = 50)
    private String firstName;

    @Column(name = "MIDDLENAME", length = 50)
    private String middleName;

    @Column(name = "LASTNAME", length = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
    private GenderEnum gender = GenderEnum.UNKNOWN;

    @Email(message = "Email should be valid")
    @Size(min = 5, max = 50)
    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "TELEPHONE", length = 50)
    private String telephone;

    @Column(name = "CELL_PHONE", length = 50)
    private String cellPhone;

    @Column(name = "RELATIONSHIP_TYPE")
    private String  relationshipType;

    @Column(name = "NOTES")
    private String notes;
}
