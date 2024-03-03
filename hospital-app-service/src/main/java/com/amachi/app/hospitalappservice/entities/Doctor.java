package com.amachi.app.hospitalappservice.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
@EqualsAndHashCode(callSuper=true)
@SuperBuilder(toBuilder = true) //, buildMethodName = "buildInternal"
//@Entity
@Table(name = "DOCTOR")
@DiscriminatorValue("doctor")
public class Doctor extends Person implements Model {

	private static final long serialVersionUID = 1L;

	private String numeroId; // this is a security nubre of a physician
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch= FetchType.EAGER)
	@JoinTable(name = "PROFESSIONAL_ACTIVITY", joinColumns = @JoinColumn(name = "ID_DOCTOR", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_PROFESSIONAL_ACTIVITY", referencedColumnName = "ID_PROFESSIONAL_ACTIVITY"))
	private Set<ProfessionalActivity> specialities;
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch=FetchType.EAGER)
	@JoinTable(name = "DOCTOR_HOSPITAL", joinColumns = @JoinColumn(name = "ID_DOCTOR", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_HOSPITAL", referencedColumnName = "ID_HOSPITAL"))
	private Set<Hospital> hospitals;
	
//	@OneToMany(mappedBy = "consultationMakeByDoctor", fetch = FetchType.EAGER, cascade=CascadeType.REFRESH , orphanRemoval=true)
//	private Set<Consultation> doctorMakeConsultations;
//
//	@OneToMany(mappedBy = "consultationAsksByDoctor", fetch = FetchType.EAGER, cascade=CascadeType.REFRESH , orphanRemoval=true)
//	private Set<Consultation> doctorAsksConsultations;
}
