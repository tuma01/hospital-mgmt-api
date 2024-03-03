package com.amachi.app.hospitalappservice.dto;

import com.amachi.app.hospitalappservice.entities.Hospital;
import com.amachi.app.hospitalappservice.entities.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
@EqualsAndHashCode(callSuper=true)
@Schema(name = "Nurse", description = "Schema to hold Nurse information")
public class NurseDTO extends PersonDTO {
    @Schema(
            description = "Photo of Nurses "
    )
    @JsonProperty
    private Blob photo;

    @Schema(
            description = "Id Card of Nurses" +
                    " ", example = "123457"
    )
    @JsonProperty
    private String idCard;

//    @ManyToMany(mappedBy = "nurses")
//    private Set<Hospital> hospitals;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            })
//    @JoinTable(name = "HOSPITAL_NURSE",
//            joinColumns = { @JoinColumn(name = "ID_HOSPITAL") },
//            inverseJoinColumns = { @JoinColumn(name = "ID_NURSE") })
//    private Set<Hospital> hospitals = new HashSet<>();
    @Schema(
            description = "The Hospital of Nurses", example = "Hospital Jean Talon"
    )
    @JsonProperty
    private Set<HospitalDTO> hospitals = new HashSet<>();
}
