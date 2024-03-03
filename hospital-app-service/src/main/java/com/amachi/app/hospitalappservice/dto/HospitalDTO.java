package com.amachi.app.hospitalappservice.dto;

import com.amachi.app.hospitalappservice.entities.Address;
import com.amachi.app.hospitalappservice.entities.DepartmentHospital;
import com.amachi.app.hospitalappservice.entities.Nurse;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@SuperBuilder(toBuilder = true)
@Schema(name = "Hospital", description = "Schema to hold Hospital information")

public class HospitalDTO {

    @Schema(
            description = "Id Hospital of Hospital ", example = "1"
    )
    private Integer idHospital;

    @JsonProperty
    @Schema(
            description = "Name of Hospital", example = "Hospital Jean Talon"
    )    private String name;

    @JsonProperty
    @Schema(
            description = "Code Hospital of Hospital", example = "12345"
    )
    private String codeHospital;

    @JsonProperty
    @Schema(
            description = "The telephone of Hospital", example = "514 2367944"
    )
    private String telephone;

    @JsonProperty
    @Schema(
            description = " The address of Hospital"
    )
    private Address address;

//	@ManyToMany(cascade = CascadeType.REFRESH, fetch=FetchType.EAGER)
//	@JoinTable(name = "HOSPITAL_NURSE", joinColumns = @JoinColumn(name = "ID_HOSPITAL", referencedColumnName = "ID_HOSPITAL"), inverseJoinColumns = @JoinColumn(name = "ID_NURSE", referencedColumnName = "ID"))
//	private Set<Nurse> nurses;

    @JsonProperty
    @Schema(
            description = "The Nurses of Hospital"
    )
    private Set<Nurse> nurses = new HashSet<>();


//	@ManyToMany(cascade = CascadeType.REFRESH, fetch=FetchType.EAGER)
//	@JoinTable(name = "HOSPITAL_DEPARTMENT_HOSPITAL", joinColumns = @JoinColumn(name = "ID_HOSPITAL", referencedColumnName = "ID_HOSPITAL"), inverseJoinColumns = @JoinColumn(name = "ID_DEPARTMENT_HOSPITAL", referencedColumnName = "ID_DEPARTMENT_HOSPITAL"))
//	private Set<DepartmentHospital> departmentHospitals;

    @JsonProperty
    @Schema(
            description = "The Department of Hospital"
    )
    private Set<DepartmentHospital> departmentHospitals;
}
