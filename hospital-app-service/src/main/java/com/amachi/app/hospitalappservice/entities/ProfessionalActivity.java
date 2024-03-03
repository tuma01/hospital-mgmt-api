package com.amachi.app.hospitalappservice.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;


@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Builder
@Entity
@Table(name = "PROFESSIONAL_ACTIVITY")
public class ProfessionalActivity implements Model {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROFESSIONAL_ACTIVITY", nullable = false)
    private Integer idProfessionalActivity;
    
    @Column(name = "NAME", unique = true,  nullable = false, length = 100)
    private String name;
    
    @Column(name = "DESCRIPTION", length = 250)
    private String description;
}
