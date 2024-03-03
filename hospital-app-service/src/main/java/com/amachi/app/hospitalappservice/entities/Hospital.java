package com.amachi.app.hospitalappservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HOSPITAL")
public class Hospital implements Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_HOSPITAL")
	private Integer idHospital;

	@NotNull
	@Column(name = "NAME", length = 50)
	private String name;
	
	@NotNull
	@Column(name = "CODE_HOSPITAL", length = 50)
	private String codeHospital;
	
	@Column(name = "TELEPHONE", length = 50)
    private String telephone;
	
//	@ManyToMany(mappedBy = "hospitals")
//	private Set<Doctor> doctors;
//
//
//	@OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY, cascade=CascadeType.REFRESH , orphanRemoval=true)
//	private Set<Consultation> consultations;
	
	@lombok.EqualsAndHashCode.Exclude
	@lombok.ToString.Exclude
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_ID_ADDRESS", foreignKey = @ForeignKey(name = "FK_HOSPITAL_ADDRESS"), referencedColumnName = "ID_ADDRESS")
	private Address address;

//	@ManyToMany(cascade = CascadeType.REFRESH, fetch=FetchType.EAGER)
//	@JoinTable(name = "HOSPITAL_NURSE", joinColumns = @JoinColumn(name = "ID_HOSPITAL", referencedColumnName = "ID_HOSPITAL"), inverseJoinColumns = @JoinColumn(name = "ID_NURSE", referencedColumnName = "ID"))
//	private Set<Nurse> nurses;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(name = "HOSPITAL_NURSE",
			joinColumns = { @JoinColumn( name = "ID_HOSPITAL", referencedColumnName = "ID_HOSPITAL") },
			inverseJoinColumns = { @JoinColumn(name = "ID", referencedColumnName = "ID") })
	private Set<Nurse> nurses = new HashSet<>();


//	@ManyToMany(cascade = CascadeType.REFRESH, fetch=FetchType.EAGER)
//	@JoinTable(name = "HOSPITAL_DEPARTMENT_HOSPITAL", joinColumns = @JoinColumn(name = "ID_HOSPITAL", referencedColumnName = "ID_HOSPITAL"), inverseJoinColumns = @JoinColumn(name = "ID_DEPARTMENT_HOSPITAL", referencedColumnName = "ID_DEPARTMENT_HOSPITAL"))
//	private Set<DepartmentHospital> departmentHospitals;

	@OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY, cascade=CascadeType.ALL , orphanRemoval=true)
	private Set<DepartmentHospital> departmentHospitals;

}
