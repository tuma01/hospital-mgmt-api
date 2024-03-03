package com.amachi.app.hospitalappservice.dto.search;

import com.amachi.app.hospitalappservice.common.util.TypeRoomEnum;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Hidden
public class RoomSearchDTO {
	private Integer idRoom;
	private Integer numberRoom;
	private TypeRoomEnum typeRoom;
	private Boolean unvailable;
}
