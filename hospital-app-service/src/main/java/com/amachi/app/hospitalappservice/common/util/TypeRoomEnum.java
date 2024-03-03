package com.amachi.app.hospitalappservice.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
//@AllArgsConstructor
public enum TypeRoomEnum {
	
	PRIVATE("Private"),
	NOT_PRIVATE("Not Private");

	public final String label;

	TypeRoomEnum(String label) {
		this.label = label;
	}
}
