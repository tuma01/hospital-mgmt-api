package com.amachi.app.hospitalappservice.dto;

import com.amachi.app.hospitalappservice.common.util.TypeRoomEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Room", description = "Schema to hold Room information")
public class RoomDTO {

    @JsonProperty
    @Schema(
            description = "Id Room of Hospital Room", hidden = true
    )
    private Integer idRoom;

    @JsonProperty
    @Schema(
            description = "Number of Room ", example = "10"
    )
    private Integer numberRoom;

    @JsonProperty
    @Schema(
            description = "Capacity Room of Hospital", example = "2"
    )
    private Integer capacity;

    @JsonProperty
    @Schema(
            description = "this is type of room", example = "NOT_PRIVATE"
    )
    private TypeRoomEnum typeRoom; //1 privada  y no privada

    @JsonProperty
    @Schema(
            description = "this is number of beds Room", example = "4"
    )
    private Integer numberOfBeds;

    @JsonProperty
    @Schema(
            description = "this is the floor where the room in", example = "2"
    )
    private Integer blockFloor;

    @JsonProperty
    @Schema(
            description = "this is the logical column which indicate that whether the room is available or not", example = "true"
    )
    private Boolean unavailable;

    @JsonProperty
    @Schema(
            description = "this is the block where the room in", example = "A"
    )
    private String blockCode;

}
