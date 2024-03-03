package com.amachi.app.hospitalappservice.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Builder
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "COUNTRY", uniqueConstraints = {
        @UniqueConstraint(name = "UK_CODE_COUNTRY", columnNames = {"CODE_COUNTRY"}),
        @UniqueConstraint(name = "UK_NAME_COUNTRY", columnNames = {"NAME"})
})
public class Country extends Auditable<String> implements Model {// extends EntiteParent {

    private static final long serialVersionUID = 6569537495441020398L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COUNTRY")
    private Integer idCountry;

    @NotNull(message = "iso code shouldn't be null")
    @Column(name = "ISO")
    @Schema(
			description = "ISO code Country of Hospital", example = "BO"
	)
    private String iso;

    @NotEmpty(message = "Name of Country can not be a null or empty")
    @Column(name = "NAME", nullable = false, length = 80)
    private String name;

//    @NotNull(message = "Nice Name of Country can not be a null or empty")
    @NotEmpty(message = "Nice Name of Country can not be a null or empty")
    @Column(name = "NICE_NAME", length = 80)
    private String niceName;

    @Column(name = "ISO3", nullable = true, length = 3)
    private String iso3;

    @Column(name = "NUM_CODE")
    private Integer numCode;

    @Column(name = "PHONE_CODE")
//    @Size(max = 5, min = 1, message = "{user.name.invalid}")
    @NotNull(message = "Please enter Phone code")
    private Integer phoneCode;

//    @Embedded
//    private UserConnexion userConnexion;
}
