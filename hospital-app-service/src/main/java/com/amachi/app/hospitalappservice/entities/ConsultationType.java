package com.amachi.app.hospitalappservice.entities;

import lombok.*;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "CONSULTATION_TYPE")
public class ConsultationType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONSULTATION_TYPE", nullable = false)
	private Integer idConsultationType;
	
	@Column(name = "NAME", unique = true, nullable = false, length = 100)
    private String name;
	
	@Column(name = "DESCRIPTION", length = 250)
	private String description;

	@Column(name = "DEPARTMENT", length = 150)
	private String department;

}
