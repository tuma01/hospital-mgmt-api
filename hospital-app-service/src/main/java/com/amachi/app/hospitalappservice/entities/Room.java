package com.amachi.app.hospitalappservice.entities;

import com.amachi.app.hospitalappservice.common.util.TypeRoomEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "ROOM")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROOM")
	private Integer idRoom;



	@Column(name = "CAPACITY")
	private Integer capacity;

	@Column(name = "TYPE_ROOM")
	@Enumerated(EnumType.STRING)
	private TypeRoomEnum typeRoom; //1 privada  y no privada

	@Column(name = "NUMBER_OF_BEDS")
	private Integer numberOfBeds;

	@Column(name = "NUMBER_ROOM")
	private Integer numberRoom;

	@Column(name = "BLOCK_FLOOR")
	private Integer blockFloor;

	@NotNull(message = "blockCode shouldn't be null")
	@NotBlank(message = "blockCode shouldn't be blank")
	@Column(name = "BLOCK_CODE", nullable = false, length = 10)
	private String blockCode;

	@Column(name = "UNAVAILABLE")
	private Boolean unavailable;




}
