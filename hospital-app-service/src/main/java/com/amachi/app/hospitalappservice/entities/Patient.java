package com.amachi.app.hospitalappservice.entities;

import com.amachi.app.hospitalappservice.common.util.StatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.Builder.Default;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import java.sql.Blob;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
@EqualsAndHashCode(callSuper=true)
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "PATIENT")
@DiscriminatorValue("patient")
@PrimaryKeyJoinColumn( name = "id" )
//@JsonIgnoreProperties("patientContacts")
public class Patient extends Person implements Model { 

	private static final long serialVersionUID = -5215320291734234595L;
	
//	@Column(name = "ID_CARD", unique = true, nullable = false, length = 100)
	@Column(name = "ID_CARD", unique = true, length = 100)
	private String idCard;

	@NotNull
	@Column(name = "FULL_NAME", length = 70)
	private String fullName;
	
	@Default
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private StatusEnum status = StatusEnum.INACTIVE;

	@Column(name = "OCCUPATION")
	private String occupation;

	@Column(name = "NATIONALITY")
	private String nationality;

	@Column(name = "DEGREE_OF_INSTRUCTION")
	private String degreeOfInstruction;

	@JsonBackReference
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "FK_ID_COUNTRY", foreignKey = @ForeignKey(name = "FK_PATIENT_COUNTRY"))
	private Country countryOfBirth;

//	@OneToOne
//	@JoinColumn(name = "FK_ID_PROFESSIONAL_ACTIVITY", foreignKey = @ForeignKey(name = "FK_PATIENT_PROFESSIONAL_ACTIVITY"))
//	private ProfessionalActivity professionalActivity;

	@JsonBackReference
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "FK_ID_ROOM", foreignKey = @ForeignKey(name = "FK_PATIENT_ROOM"), referencedColumnName = "ID_ROOM")
	private Room  room;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "FK_ID_PATIENT_CONTACT", referencedColumnName = "ID_PATIENT_CONTACT", foreignKey = @ForeignKey(name = "FK_PATIENT_PATIENT_CONTACT"))
	private PatientContact patientContact;

//	@Lob
//	@Column(name = "PHOTO", length = 100000)
//	private Blob photo;
	@Lob
	@Column(name = "PHOTO", columnDefinition = "mediumblob")
	private Blob photo;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "FK_ID_INSURANCE", referencedColumnName = "ID_INSURANCE", foreignKey = @ForeignKey(name = "FK_PATIENT_INSURANCE"))
	private Insurance insurance;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "FK_ID_NURSE", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_PATIENT_NURSE"))
	private Nurse nurse;

//	@Column(name = "REASON_FOR_HOSPITALIZATION")
//	private String reasonForHospitalization;
//
//	@Column(name = "CURRENT_DISEASE")
//	private String currentDisease;



//	@Default
//	@lombok.EqualsAndHashCode.Exclude
//	@lombok.ToString.Exclude
//	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade=CascadeType.DETACH , orphanRemoval=true)
//	private Set<Consultation> consultations = new LinkedHashSet<>();




	// **************************************************************************//
//	private Long photo;
//	private Long numHistClinico; //OBjeto
//	private Long Observations;
//	private String bloodGroup;
}
