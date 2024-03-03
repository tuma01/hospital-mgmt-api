package com.amachi.app.hospitalappservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@EqualsAndHashCode(callSuper=true)
//@SuperBuilder(toBuilder = true) // ,buildMethodName = "buildInternal"
@Entity
@Table(name = "INSURANCE")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INSURANCE")
    private Integer idInsurance;

    @Column(name = "INSURANCE_NUMBER")
    private Integer insurance_Number;

    @NotNull(message = "Name code shouldn't be null")
    @Column(name = "NAME")
    @Schema(
            description = "Name of Insurance company", example = "Seguro de vida Libertad"
    )
    private String name;

    @Column(name = "TELEPHONE", length = 50)
    private String telephone;

    @Column(name = "FAX", length = 50)
    private String fax;

    @Column(name = "WEB_SITE", length = 100)
    private String webSite;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "INSURANCE_DATE", length = 10)
    private LocalDate insuranceDate;

    @lombok.EqualsAndHashCode.Exclude
    @lombok.ToString.Exclude
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_ID_ADDRESS", foreignKey = @ForeignKey(name = "FK_INSURANCE_ADDRESS"), referencedColumnName = "ID_ADDRESS")
    private Address address;
}
