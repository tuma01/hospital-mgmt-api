package com.amachi.app.hospitalappservice.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "DEPARTMENT_HOSPITAL")
public class DepartmentHospital{//} extends Auditable<String> implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEPARTMENT_HOSPITAL")
    private Integer idDepartmentHospital;

    @NotNull(message = "Name of Department of Hospital shouldn't be null")
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ID_HOSPITAL")
    private Hospital hospital;

}
