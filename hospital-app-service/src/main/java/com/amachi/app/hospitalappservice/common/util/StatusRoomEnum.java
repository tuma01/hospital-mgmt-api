package com.amachi.app.hospitalappservice.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
//@AllArgsConstructor
public enum StatusRoomEnum {
	
	BUSY("Busy"),
	FREE("Free"),
	RESERVED("Reserved");

	public final String label;

	StatusRoomEnum(String label) {
		this.label = label;
	}
}
