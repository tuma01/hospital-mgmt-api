package com.amachi.app.hospitalappservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder @ToString
@Entity
@Table
public class Address implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ADDRESS")
    private Long idAddress;

    @NotNull(message = "address shouldn't be null")
    @Column(name = "ADDRESS1", length = 100)
    private String address1;

    @Column(name = "ADDRESS2", length = 100)
    private String address2;

    @NotNull(message = "city shouldn't be null")
    @Column(name = "CITY", length = 100)
    private String city;

    @Column(name = "POSTAL_CODE", length = 10)
    private String postalCode;

    private String location;

    @ManyToOne(cascade = CascadeType.MERGE, fetch= FetchType.EAGER)
    @JoinColumn(name = "FK_ID_COUNTRY", nullable = false, foreignKey = @ForeignKey(name = "FK_ADDRESS_COUNTRY"))
    private Country country;
}
