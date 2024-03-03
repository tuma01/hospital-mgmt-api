package com.amachi.app.hospitalappservice.entities;

import com.amachi.app.hospitalappservice.common.util.CivilStatusEnum;
import com.amachi.app.hospitalappservice.common.util.GenderEnum;
import com.amachi.app.hospitalappservice.common.util.MaritalStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
//@MappedSuperclass
@Data
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING,	name = "person_type")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Person extends Auditable<String> implements Model {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TITLE", length = 50)
	private String title;
	
	@Column(name = "FIRSTNAME", length = 50, nullable = false)
	@NotNull
	@NotBlank(message = "firstName is required")
	@Size(min = 3, max = 50)
	private String firstName;
	
	@Column(name = "MIDDLENAME", length = 50)
	private String middleName;
	
	@NotBlank(message = "lastName is required")
	@Column(name = "LASTNAME", length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "DAY_OF_BIRTH", length = 2)
    private Integer dayOfBirth;
    
    @Column(name = "MONTH_OF_BIRTH", length = 2)
    private Integer monthOfBirth;
    
    @Column(name = "YEAR_OF_BIRTH", length = 4)
    private Integer yearOfBirth;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "BIRTHDAY", length = 10)
	private LocalDate birthday;

	@Enumerated(EnumType.STRING)
	@Column(name = "CIVIL_STATUS")
	private CivilStatusEnum civilStatus = CivilStatusEnum.SOLTERO;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
	private GenderEnum gender = GenderEnum.FEMALE;
	
	@lombok.EqualsAndHashCode.Exclude
	@lombok.ToString.Exclude
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_ID_ADDRESS", foreignKey = @ForeignKey(name = "FK_PERSON_ADDRESS"), referencedColumnName = "ID_ADDRESS")
	private Address address;
	
	@Email(message = "Email should be valid")
	@Size(min = 5, max = 50)
	@Column(name = "EMAIL", length = 50)
	private String email;
	
	@Column(name = "TELEPHONE", length = 50)
    private String telephone;
	
	@Column(name = "CELL_PHONE", length = 50)
    private String cellPhone;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "MARITAL_STATUS")
	private MaritalStatusEnum maritalStatus;
}
